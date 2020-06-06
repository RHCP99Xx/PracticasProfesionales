/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import database.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pojo.SelectionPojo;

/**
 *
 * @author Adair Hernández
 */
public class Selection {

    public void saveSelections(ArrayList<SelectionPojo> selections) {
        Connection connection = DatabaseConnector.getConnection();
        
        try {
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
