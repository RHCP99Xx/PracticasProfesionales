
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
    /**
     * 
     * @return 
     * @throws java.lang.Exception 
     */
    public ArrayList<StudentPojo> getStudents() throws Exception{
        DatabaseConnector dc = new DatabaseConnector();        
        ArrayList<StudentPojo> studentsList = new ArrayList<>();
        
            Connection connection = dc.getConnection();
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery("SELECT Usuario.nombres,"
                    + " Usuario.apellidos, Usuario.idUsuario, Estudiante.matricula"
                    + " FROM Estudiante INNER JOIN Usuario ON "
                    + "Estudiante.idUsuario = Usuario.idUsuario");
            StudentMapper sm = new StudentMapper();
            studentsList = sm.mapAll(rs);

        return studentsList;
    }
    
    /**
     * 
     * @param studentStatus
     * @return
     * @throws Exception 
     */
    
    /* Este método hace una consulta a la base de datos utilizando como parámetro de búsqueda el status del estudiante.
    Obtiene los nombres del estudiante y los vuelca dentro de la clase StudentPojo con la ayuda de un Mapper.
    */
    public ArrayList<StudentPojo> getStudentsByStatus(String studentStatus) throws Exception{
        DatabaseConnector dc = new DatabaseConnector();
        ArrayList<StudentPojo> studentsList = new ArrayList<>();
            Connection connection = dc.getConnection();
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery("SELECT usuario.nombres, "
                    + "usuario.apellidos FROM usuario INNER JOIN estudiante "
                    + "ON estudiante.idUsuario = usuario.idUsuario WHERE "
                    + "estudiante.status = '"+studentStatus+"';");
            StudentMapper sm = new StudentMapper();
            studentsList = sm.mapAllOnlyNames(rs);
            
        return studentsList;
    }
    
    /* Este método obtiene un único estudiante y se realiza la búsqueda conforme al parámetro enrollment que es
    la matrícula del estudiante. Finalmente se canaliza la consulta hacia el mapper para que este realice la instancia
    del objeto y rellene sus atributos
    */
    /**
     * 
     * @param enrollment
     * @return 
     * @throws java.lang.Exception 
     */
    public StudentPojo getOnlyOneStudent(String enrollment) throws Exception {
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

    }
}
