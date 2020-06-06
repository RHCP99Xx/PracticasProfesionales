/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Adair Hernández
 */
public class UserPojo {
    protected int userId;
    protected String name;
    protected String lastName;
    protected String email;
    protected String password;
    protected String type;
    
    
    public int getUserId(){
        return this.userId;
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    
    
    
}
