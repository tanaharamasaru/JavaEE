/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Users;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author BBC300198
 */
@Stateless
@LocalBean
public class LoginSessionBean {

//    @PersistenceContext(unitName="EnterpriseApplication1-warPU")
    @PersistenceContext
    private EntityManager entityManager;
    
    public Users find(String key) {
        return entityManager.find(Users.class, key);
    }

}
