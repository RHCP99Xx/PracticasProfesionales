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
    
    /**
     * Este método devuelve el id del usuario.
     * @return el id del usuario.
     */
    public int getUserId(){
        return this.userId;
    }
    
    /**
     * Este método asigna un id al usuario.
     * @param userId el id que se asignará al usuario.
     */
    public void setUserId(int userId){
        this.userId = userId;
    }
    
    /**
     * Este método devuelve el nombre del usuario.
     * @return el nombre del usuario.
     */
    public String getName() {
        return name;
    }

    /**
     * Este método asigna un nombre al usuario.
     * @param name el nombre que se asignará al usuario.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Este método devuelve los apellidos del usuario.
     * @return los apellidos del usuario.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Este método asigna apellidos al usuario.
     * @param lastName los apellidos que se asignarán al usuario.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Este método devuelve el email del usuario.
     * @return el email del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Este método asigna un email al usuario.
     * @param email el email que se asignará al usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Este método devuelve la contraseña del usuario.
     * @return la contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Este método asigna una contraseña al usuario.
     * @param password la contraseña que se asignará al usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Este método devuelve el tipo de usuario. Los tipos de usuario son:
     * "Estudiante", "Coordinador" y "Profesor".
     * @return el tipo de usuario.
     */
    public String getType() {
        return this.type;
    }
    
    /**
     * Este método asigna un tipo de usuario al usuario.
     * @param type el tipo de usuario que se asignará al usuario.
     */
    public void setType(String type){
        this.type = type;
    }
    
    
    
    
}
