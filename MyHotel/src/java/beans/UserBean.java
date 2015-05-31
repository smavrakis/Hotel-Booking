/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
        user.setPassword(password);
        
        em.persist(user);
    }
}
