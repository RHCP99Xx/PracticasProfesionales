/*
   public class Participation
   1. public class Participation
   2. public ParticipationPojo getParticipation(String studentName)
    
*/
package models;

import database.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import pojo.LinkedOrganizationPojo;
import pojo.ParticipationPojo;
import pojo.ProjectPojo;
import pojo.StudentPojo;


public class Participation {
    
    private String holaxd;
    
    public Participation(){}
    
    /*
    Este método hace una consulta a la base de datos y devuelve la uníon del estudiante con su proyecto y la organización
    vínculada a su proyecto, posteriormente crea una instancia de cada uno de los objetos que se ven involucrados, que son:
    ProjectPojo, StudentPojo y LinkedOrganizationPojo. Finalmente llena los atributos del objeto que se necesitan en la clase
    StudentProgressController
    */
    
    /**
     * 
     * @param studentName
     * @return 
     * @throws java.lang.Exception 
     */
    public ParticipationPojo getParticipation(String studentName) throws Exception{
       ParticipationPojo participation = null;

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
                    + " WHERE Usuario.nombres = '"+studentName+"';");
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
        return participation;  
    }  
}
