/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.backingbean;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author BBC300198
 */
@Named
@RequestScoped
public class LoginBackingBean {
    
    private String id;
    private String password;

    public String login() {
        
        // TODO ここでログイン処理
        System.out.println("id = " + id + ":" + "password " + password);
        return null;
    }
    
    /**
     * @return the Id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
