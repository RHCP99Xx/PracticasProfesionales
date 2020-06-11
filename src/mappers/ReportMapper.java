/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojo.ReportPojo;

/**
 *
 * @author Adair Hernández
 */
public class ReportMapper {

    public ArrayList<ReportPojo> mapAll(ResultSet rs) throws SQLException {
        ArrayList<ReportPojo> reportsList = new ArrayList<>();
        while (rs.next()) {
            ReportPojo report = new ReportPojo();
            report.setName(rs.getString("nombre"));
            report.setUploadDate(rs.getDate("fechaSubida"));
            report.setInitialDate(rs.getDate("fechaInicio"));
            report.setEndingDate(rs.getDate("fechaFin"));
            report.setCoveredHours(rs.getInt("horasCubiertas"));
            report.setStatus(rs.getString("status"));
            reportsList.add(report);
        }
        return reportsList;
    }
}
