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
   
    /**
     * Este método devuelve una única instancia del objeto UserSession.
     * En caso de que no exista una instancia, esta se crea y se retorna; si 
     * por el contrario ya existe una instancia, no se crea otra, sino que se
     * retorna la existente.
     * @return una única instancia del objeto UserSession.
     */
    public static UserSession getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new UserSession();
        }
        return uniqueInstance;
    }
    
    /**
     * Este método asigna un objeto UserPojo a la instancia de UserSession.
     * Este objeto UserPojo es el usuario que inició sesión en el sistema.
     * @param user el usuario que se 
     */
    public void login(UserPojo user){
        this.user = user;
    }
    
    /**
     * Este método remueve el objeto UserPojo de la instancia UserSession
     * y hace nula la única instancia de UserSession.
     */
    public void logout(){
        this.uniqueInstance = null;
        this.user = null;
    }
    
    /**
     * Este método devuelve el objeto UserPojo asignado a la única instancia de
     * UserSession. Este objeto UserPojo es el usuario que se encuentra en una
     * sesión activa dentro del sistema.
     * @return 
     */
    public UserPojo getUser(){
        return this.user;
    }
}
