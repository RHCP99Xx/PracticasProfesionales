package models;

import database.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pojo.LinkedOrganizationPojo;
import pojo.ParticipationPojo;
import pojo.ProjectPojo;
import pojo.StudentPojo;


public class Participation {
    
    private String holaxd;
    
    public Participation(){}
    
    public ParticipationPojo getParticipation(String studentName){
       ParticipationPojo participation = null;
        try{
            DatabaseConnector dc = new DatabaseConnector();            
            Connection connection = dc.getConnection();
            Statement query = connection.createStatement();
            ResultSet result = query.executeQuery("SELECT Proyecto.nombre,"
                    + " Organizacion_vinculada.nombre AS OVname,"
                    + " Usuario.nombres, Usuario.apellidos, Usuario.correo,"
                    + " Estudiante.matricula, Estudiante.telefono FROM"
                    + " Participacion INNER JOIN Estudiante ON"
                    + " Participacion.matricula = Estudiante.matricula"
                    + " INNER JOIN Usuario ON Usuario.idUsuario"
                    + " = Estudiante.idUsuario INNER JOIN Proyecto ON"
                    + " Participacion.idProyecto = Proyecto.idProyecto"
                    + " INNER JOIN Organizacion_vinculada ON"
                    + " Proyecto.idOV = Organizacion_vinculada.idOV"
                    + " WHERE Estudiante.matricula = '"+studentName+"';");
            dc.closeConnection();
            ProjectPojo project = new ProjectPojo();
            StudentPojo student = new StudentPojo();
            LinkedOrganizationPojo organization = new LinkedOrganizationPojo();
           
            while(result.next()){
                
                project.setName(result.getString("nombre"));
                organization.setName(result.getString("OVname"));
                student.setName(result.getString("nombres"));
                student.setLastName(result.getString("apellidos"));
                student.setEmail(result.getString("correo"));
                student.setEnrollment(result.getString("matricula"));
                student.setPhone(result.getString("telefono"));
                participation = new ParticipationPojo(student, project, organization);
                
            }
        }catch(SQLException e){
            System.out.println("Hola, excepcion SQL");
        }
        return participation;  
    }  
}
