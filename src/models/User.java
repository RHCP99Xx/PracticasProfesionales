/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import database.DatabaseConnector;
import exceptions.NonExistentUserException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mappers.UserMapper;

import pojo.UserPojo;

/**
 *
 * @author Adair Hernández
 */
public class User {



    /**
     * Recupera de la base de datos al usuario con la contraseña y correo
     * electrónico que se pasan como parámetro.
     * Este método es invocado por getUser() para atrapar las excepciones
     * que podrían ocurrir.
     * @param email el email del usuario a recuperar de la base de datos
     * @param password la contraseña del usuario a recuperar de la base
     * de datos
     * @return un usuario de tipo UserPojo. Si no existe en la base de datos 
     * un usuario con el email y contraseña especificados, el usuario retornado
     * estará vacío.
     * @throws SQLException 
     */
    public UserPojo getUser(String email, String password) 
            throws SQLException, NonExistentUserException{
        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();
        Statement query = connection.createStatement();
        ResultSet resultSet = query.executeQuery("SELECT idUsuario, nombres, apellidos, correo, tipo"
                + " FROM Usuario WHERE correo = '" + email
                + "' AND contrasenia = '" + password + "';");    
        UserMapper um = new UserMapper();
        UserPojo user = um.map(resultSet);
        if(user == null){
            throw new NonExistentUserException("No existe un usuario con los datos ingresados");
        }
        return user;
    }

}
