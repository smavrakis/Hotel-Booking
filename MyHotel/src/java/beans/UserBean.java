/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.UserGroups;
import entities.Users;
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
}
