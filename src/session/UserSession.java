/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import pojo.UserPojo;

/**
 *
 * @author Adair Hernández
 */
public class UserSession {
    
    private UserPojo user;
    private static UserSession uniqueInstance;
   
    
    public static UserSession getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new UserSession();
        }
        return uniqueInstance;
    }
    
    public void setUserData(){
        
    }
    
    public void login(UserPojo user){
        this.user = user;
    }
    
    public void logout(){
        this.uniqueInstance = null;
        this.user = null;
    }
    
    public UserPojo getUser(){
        return this.user;
    }
}
