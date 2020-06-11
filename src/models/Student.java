
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import database.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mappers.StudentMapper;
import pojo.StudentPojo;

public class Student {

    public Student() {

    }

    public ArrayList<StudentPojo> getStudents() {
        DatabaseConnector dc = new DatabaseConnector();        
        ArrayList<StudentPojo> studentsList = new ArrayList<>();
        try {
            Connection connection = dc.getConnection();
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery("SELECT Usuario.nombres,"
                    + " Usuario.apellidos, Usuario.idUsuario, Estudiante.matricula"
                    + " FROM Estudiante INNER JOIN Usuario ON "
                    + "Estudiante.idUsuario = Usuario.idUsuario");
            StudentMapper sm = new StudentMapper();
            studentsList = sm.mapAll(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return studentsList;
    }
    
    public ArrayList<StudentPojo> getStudentsByStatus(String studentName){
        DatabaseConnector dc = new DatabaseConnector();
        ArrayList<StudentPojo> studentsList = new ArrayList<>();
        try{
            Connection connection = dc.getConnection();
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery("SELECT usuario.nombres, "
                    + "usuario.apellidos FROM usuario INNER JOIN estudiante "
                    + "ON estudiante.idUsuario = usuario.idUsuario WHERE "
                    + "estudiante.status = '"+studentName+"';");
            StudentMapper sm = new StudentMapper();
            studentsList = sm.mapAll(rs);
            
        }catch(SQLException e){
            System.out.println("Excepción en getStudentByStatus");
        }
        return studentsList;
    }

    public StudentPojo getOnlyOneStudent(String enrollment) {
        try {
            DatabaseConnector dc = new DatabaseConnector();
            Connection connection = dc.getConnection();
            Statement query = connection.createStatement();
            ResultSet result = query.executeQuery("SELECT usuario.nombres, usuario.apellidos, usuario.correo, "
                    + "usuario.contasenia, estudiante.matricula, estudiante.telefono "
                    + "FROM usuario inner join estudiante on usuario.idUsuario = estudiante.idUsuario "
                    + "WHERE estudiante.matricula = '" + enrollment + "';");
            dc.closeConnection();
            StudentMapper sm = new StudentMapper();
            StudentPojo student = sm.map(result);
            return student;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
