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

/**
 *
 * @author Adair Hernández
 */
public class Project {
    public ArrayList<ProjectPojo> getProjects(){
        ArrayList<ProjectPojo> projectsList = new ArrayList<>();
        Connection connection = DatabaseConnector.getConnection();
        try{
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery("SELECT Proyecto.nombre,"
                    + " Proyecto.numeroEstudiantesSolicitados,"
                    + " Proyecto.numeroEstudiantesAsignados,"
                    + " Organizacion_vinculada.nombre AS nombreOrganizacion"
                    + " FROM Proyecto INNER JOIN Organizacion_vinculada"
                    + " ON Proyecto.idOv = Organizacion_vinculada.idOv");
            while(rs.next()){
                ProjectPojo project = new ProjectPojo();
                project.setName(rs.getString("nombre"));
                project.setRequiredStudents(rs.getInt("numeroEstudiantesSolicitados"));
                project.setAssignedStudents(rs.getInt("numeroEstudiantesAsignados"));
                LinkedOrganizationPojo linkedOrganization = new LinkedOrganizationPojo();
                linkedOrganization.setName(rs.getString("nombreOrganizacion"));
                projectsList.add(project);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return projectsList;
    }
}
