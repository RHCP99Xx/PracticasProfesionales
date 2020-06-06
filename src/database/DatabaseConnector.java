package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
        
    protected String hostName;
    protected String port;        
    private String databaseName;
    private String username;
    private String password;
    private static DatabaseConnector uniqueInstance;
    
    //public static String url = "jdbc:mariadb://" + hostName + ":" + port + "/" +  databaseName + "?user=" + username + "&password=" + password;
    
    private DatabaseConnector(){
        this.hostName = "localhost";
        this.port = "3306";
        this.databaseName = "sistemapp";
        this.username = "root";
        this.password = "";
    }

    
    public static Connection getConnection(){
        Connection connection = null;        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sistemapp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT-6", "root", "30dpr4319n");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void closeConnection(Connection c){
        try{
            c.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }            
}
