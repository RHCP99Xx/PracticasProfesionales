/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.UserPojo;

/**
 *
 * @author Adair Hernández
 */
public class UserMapper {

    public UserPojo map(ResultSet rs) throws SQLException{
        UserPojo user = null;
        while (rs.next()) {
            user = new UserPojo();
            user.setUserId(rs.getInt("idUsuario"));
            user.setName(rs.getString("nombres"));
            user.setLastName(rs.getString("apellidos"));
            user.setEmail(rs.getString("correo"));
            user.setType(rs.getString("tipo"));
        }
        return user;
    }
}
