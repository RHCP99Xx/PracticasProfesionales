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
import pojo.RecordPojo;

/**
 *
 * @author Adair Hernández
 */
public class Record {
    
    public RecordPojo getRecord(int userId){
            DatabaseConnector dc = new DatabaseConnector();            
            
        RecordPojo record = null;
        try{
            Connection connection = dc.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT calificacionFinal,"
                    + "comentarios, totalHorasRealizadas "
                    + "FROM Expediente "
                    + "INNER JOIN Participacion ON Expediente.idParticipacion = Participacion.idParticipacion "
                    + "INNER JOIN Estudiante ON Participacion.matricula = Estudiante.matricula "
                    + "INNER JOIN Usuario ON Usuario.idUsuario = Estudiante.idUsuario "
                    + "WHERE Usuario.idUsuario = " + userId);
            while(resultSet.next()){
                record = new RecordPojo();
                record.setFinalGrade(resultSet.getFloat("calificacionFinal"));
                record.setComments(resultSet.getString("comentarios"));
                record.setTotalHoursCovered(resultSet.getInt("totalHorasRealizadas"));
            }
        }catch(SQLException e){
            
        }
        return record;
    }
    
     public RecordPojo getRecordByName(String name){
            DatabaseConnector dc = new DatabaseConnector();            
            
        RecordPojo record = null;
        try{
            Connection connection = dc.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT calificacionFinal,"
                    + "comentarios, totalHorasRealizadas "
                    + "FROM Expediente "
                    + "INNER JOIN Participacion ON Expediente.idParticipacion = Participacion.idParticipacion "
                    + "INNER JOIN Estudiante ON Participacion.matricula = Estudiante.matricula "
                    + "INNER JOIN Usuario ON Usuario.idUsuario = Estudiante.idUsuario "
                    + "WHERE Usuario.nombres = '" + name +"'");
            while(resultSet.next()){
                record = new RecordPojo();
                record.setFinalGrade(resultSet.getFloat("calificacionFinal"));
                record.setComments(resultSet.getString("comentarios"));
                record.setTotalHoursCovered(resultSet.getInt("totalHorasRealizadas"));
            }
        }catch(SQLException e){
            
        }
        return record;
    }
}
