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
    
    public ParticipationPojo getParticipation(String studentEnrollment){
       ParticipationPojo participation = null;
        try{
            Connection connection = DatabaseConnector.getConnection();
            Statement query = connection.createStatement();
            ResultSet result = query.executeQuery("SELECT Proyecto.nombre, Organizacion_vinculada.nombre AS OVname, Usuario.nombres, Usuario.apellidos, "
            +"Usuario.correo, Estudiante.matricula, Estudiante.telefono FROM Participa INNER JOIN Estudiante ON Participa.matricula = Estudiante.matricula "
            +"INNER JOIN Usuario ON Usuario.idUsuario = Estudiante.idUsuario INNER JOIN Proyecto ON Participa.idProyecto = Proyecto.idProyecto "
            +"INNER JOIN Organizacion_vinculada ON Proyecto.idOV = Organizacion_vinculada.idOV WHERE Estudiante.matricula = '"+studentEnrollment+"';");
            DatabaseConnector.closeConnection(connection);
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
