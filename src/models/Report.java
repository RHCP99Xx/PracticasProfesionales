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
import mappers.ReportMapper;

import pojo.ReportPojo;
import utils.DateFormatter;

/**
 *
 * @author Adair Hernández
 */
public class Report {

    public Report() {

    }

    public ArrayList<ReportPojo> getReports(int userId) {
        try {
            DatabaseConnector dc = new DatabaseConnector();
            Connection connection = dc.getConnection();
            Statement query = connection.createStatement();
            ResultSet result = query.executeQuery("SELECT Documento.nombre, Documento.fechaSubida, "
                    + "Reporte.fechaInicio, Reporte.fechaFin, Reporte.horasCubiertas, Reporte.status "
                    + "FROM Usuario INNER JOIN Estudiante ON Usuario.idUsuario = Estudiante.idUsuario "
                    + "INNER JOIN Participacion ON Estudiante.matricula = Participacion.matricula "
                    + "INNER JOIN Expediente ON Participacion.idParticipacion = Expediente.idParticipacion "
                    + "INNER JOIN Documento ON Expediente.idExpediente = Documento.idExpediente "
                    + "INNER JOIN Reporte ON Documento.idDocumento = Reporte.idDocumento "
                    + "WHERE Usuario.idUsuario = " + userId);
            dc.closeConnection();
            ReportMapper rm = new ReportMapper();
            ArrayList<ReportPojo> reports = rm.mapAll(result);
            return reports;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
        public ArrayList<ReportPojo> getReportsByName(String name) {
        try {
            DatabaseConnector dc = new DatabaseConnector();
            Connection connection = dc.getConnection();
            Statement query = connection.createStatement();
            ResultSet result = query.executeQuery("SELECT Documento.nombre, Documento.fechaSubida, "
                    + "Reporte.fechaInicio, Reporte.fechaFin, Reporte.horasCubiertas, Reporte.status "
                    + "FROM Usuario INNER JOIN Estudiante ON Usuario.idUsuario = Estudiante.idUsuario "
                    + "INNER JOIN Participacion ON Estudiante.matricula = Participacion.matricula "
                    + "INNER JOIN Expediente ON Participacion.idParticipacion = Expediente.idParticipacion "
                    + "INNER JOIN Documento ON Expediente.idExpediente = Documento.idExpediente "
                    + "INNER JOIN Reporte ON Documento.idDocumento = Reporte.idDocumento "
                    + "WHERE Usuario.nombres = '"+name+"'");
            dc.closeConnection();
            ReportMapper rm = new ReportMapper();
            ArrayList<ReportPojo> reports = rm.mapAll(result);
            return reports;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean saveReport(ReportPojo report, int recordId) throws SQLException {

        //Documento
        String fileName = report.getName();
        double fileSize = report.getSize();
        String filePath = report.getPath();

        //Reporte
        String fileStatus = report.getStatus();

        DateFormatter dateFormatter = new DateFormatter();
        java.sql.Date sqlInitialDateOfReport = dateFormatter.getSqlDate(report.getInitialDate());
        java.sql.Date sqlEndingDateOfReport = dateFormatter.getSqlDate(report.getEndingDate());

        int coveredHours = report.getCoveredHours();

        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();
        connection.setAutoCommit(false);
        Statement documentInsertionQuery = connection.createStatement();
        boolean documentInserted = documentInsertionQuery.execute("INSERT INTO Documento VALUES(NULL, '"
                + fileName + "', " + fileSize + ", '" + filePath + "', CURDATE(), " + recordId + ");");
        Statement reportInsertionQuery = connection.createStatement();
        boolean reportInserted = reportInsertionQuery.execute("INSERT INTO "
                + "Reporte VALUES(LAST_INSERT_ID(), 'Aprobado', "
                + "'" + sqlInitialDateOfReport + "'" + ", '" + sqlEndingDateOfReport + "', " + coveredHours + ");");
        connection.commit();
        connection.close();
        return true;
    }
}
