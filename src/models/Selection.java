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
import pojo.LinkedOrganizationPojo;
import pojo.ProjectPojo;
import pojo.SelectionPojo;

/**
 *
 * @author Adair Hernández
 */
public class Selection {

    public ArrayList<SelectionPojo> getStudentSelections(int userId){
                    DatabaseConnector dc = new DatabaseConnector();            
            
        ArrayList<SelectionPojo> studentSelections = new ArrayList<>();
        try{
            Connection connection = dc.getConnection();
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT Eleccion.nivelEleccion,"
                    + " Proyecto.nombre, Organizacion_vinculada.nombre AS nombreOV,"
                    + " Proyecto.numeroEstudiantesSolicitados,"
                    + " Proyecto.numeroEstudiantesAsignados"
                    + " FROM Eleccion INNER JOIN Proyecto ON"
                    + " Proyecto.idProyecto = Eleccion.idProyecto"
                    + " INNER JOIN Organizacion_vinculada ON Organizacion_vinculada.idOv = Proyecto.idOV"
                    + " INNER JOIN Estudiante ON"
                    + " Estudiante.matricula = Eleccion.matricula"
                    + " INNER JOIN Usuario ON Estudiante.idUsuario = Usuario.idUsuario"
                    + " WHERE Usuario.idUsuario = " + userId);
            while(resultSet.next()){
                SelectionPojo selection = new SelectionPojo();
                LinkedOrganizationPojo lop = new LinkedOrganizationPojo();
                ProjectPojo project = new ProjectPojo();
                lop.setName(resultSet.getString("nombreOV"));
                project.setName(resultSet.getString("nombre"));
                project.setRequiredStudents(resultSet.getInt("numeroEstudiantesSolicitados"));
                project.setAssignStudents(resultSet.getInt("numeroEstudiantesAsignados"));
                selection.setPosition(resultSet.getInt("nivelEleccion"));
                project.setLinkedOrganization(lop);
                selection.setProject(project);
                
                studentSelections.add(selection);
            }
        }catch(SQLException e){
            System.out.println("ERROR SELECTION");
        }
        return studentSelections;
    }
    
    public void saveSelections(ArrayList<SelectionPojo> selections) {
                    DatabaseConnector dc = new DatabaseConnector();            
            
        
        try {
            Connection connection = dc.getConnection();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            int selectionsSaved = 0;
            for (int i = 0; i < selections.size(); i++) {
                selectionsSaved += statement.executeUpdate(""
                        + "INSERT INTO Eleccion VALUES"
                        + " (NULL, 'S18012122', 1, 1, CURDATE(),"
                        + selections.get(i).getPosition() + ");");
            }
            if(selectionsSaved == selections.size()){
                connection.commit();
            }else{
                System.out.println("No coinciden");
                connection.rollback();
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
}
