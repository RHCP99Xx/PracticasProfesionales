/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojo.StudentPojo;


/**
 * 
 * @author edgar
 */
public class StudentMapper {
    
    /* El método mapAllOnlyNames se encarga de crear la instancia del objeto StudentPojo y guarda los registros obtenidos
    en cada uno de sus atributos. Retorna una lista del tipo StudentPojo.
    */
    /**
     * 
     * @param rs
     * @return
     * @throws SQLException 
     */
    public ArrayList<StudentPojo> mapAll(ResultSet rs) throws SQLException {
        ArrayList<StudentPojo> studentsList = new ArrayList<>();
        while (rs.next()) {
            StudentPojo student = new StudentPojo();
            student.setUserId(rs.getInt("idUsuario"));
            student.setName(rs.getString("nombres"));
            student.setLastName(rs.getString("apellidos"));
            student.setEnrollment(rs.getString("matricula"));
            studentsList.add(student);
        }
        return studentsList;
    }
    
    //Este método vuelca los registros de la base de datos en el objeto StudentPojo y devuelve un único objeto
    /**
     * 
     * @param rs
     * @return
     * @throws SQLException 
     */
    public StudentPojo map(ResultSet rs) throws SQLException {
        StudentPojo student = new StudentPojo();
        while (rs.next()) {
            student.setName(rs.getString("nombres"));
            student.setLastName(rs.getString("apellidos"));
            student.setEmail(rs.getString("correo"));
            student.setPassword(rs.getString("contasenia"));
            student.setEnrollment(rs.getString("matricula"));
            student.setPhone(rs.getString("telefono"));
        }
        return student;
    }
    
    /* El método mapAllOnlyNames se encarga de crear la instancia del objeto StudentPojo y guarda los registros obtenidos
    en el atributo names. Retorna una lista del tipo StudentPojo.
    */
    /**
     * 
     * @param rs
     * @return
     * @throws SQLException 
     */
    public ArrayList<StudentPojo> mapAllOnlyNames(ResultSet rs) throws SQLException {
        ArrayList<StudentPojo> studentsList = new ArrayList<>();
        while (rs.next()) {
            StudentPojo student = new StudentPojo();
            student.setName(rs.getString("nombres"));
            student.setLastName(rs.getString("apellidos"));
            studentsList.add(student);
        }
        return studentsList;
    }
}
