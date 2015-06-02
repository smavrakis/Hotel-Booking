/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.UserGroups;
import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Stavros
 */
@Stateless(name="User")
public class UserBean {

    @PersistenceContext
    private EntityManager em;
    
    public void register(String firstName, String lastName, String emailAddress, String username, String password){
        Users user = new Users();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(emailAddress);
        user.setUsername(username);
        String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
        user.setPassword(sha256hex);        
        em.persist(user);
        
        UserGroups group = new UserGroups();
        group.setGroupName("users");
        group.setUsername(username);
        em.persist(group);
    }
    
    public List getID(String username){
        Query query = em.createNamedQuery("Users.findID");
        query.setParameter("username", username);
        List results = query.getResultList();
        return results;
    }
    
    public String getFirstName(String username){        
        List results = getID(username);
        int id = (int)results.get(0);
        Users user = em.find(Users.class, id);
        return user.getFirstName();
    }
    
    public String getLastName(String username){
        List results = getID(username);
        int id = (int)results.get(0);
        Users user = em.find(Users.class, id);
        return user.getLastName();
    }
    
    public String getEmail(String username){
        List results = getID(username);
        int id = (int)results.get(0);
        Users user = em.find(Users.class, id);
        return user.getEmailAddress();
    }
    
    public void updateInfo(String username, String firstName, String lastName, String email){
        List results = getID(username);
        int id = (int)results.get(0);
        Users user = em.find(Users.class, id);        
        
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(email);        
        em.merge(user);
    }
}
