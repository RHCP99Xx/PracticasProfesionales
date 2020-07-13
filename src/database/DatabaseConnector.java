package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    protected String hostName;
    protected String port;
    private final String databaseName;
    private final String username;
    private final String password;
    private Connection uniqueInstance;

    //public static String url = "jdbc:mariadb://" + hostName + ":" + port + "/" +  databaseName + "?user=" + username + "&password=" + password;
    
    
    public DatabaseConnector() {
        this.hostName = "localhost";
        this.port = "3306";
        this.databaseName = "sistemapp";
        this.username = "root";
        this.password = "";
    }

    /**
     * Este método devuelve una única instancia del objeto Connection.
     * En caso de que no exista una instancia, esta se crea y se retorna; si 
     * por el contrario ya existe una instancia, no se crea otra, sino que se
     * retorna la existente.
     * @return una única instancia del objeto Connection.
     */
    public Connection getConnection(){
        if (this.uniqueInstance == null) {
            try{
                this.uniqueInstance = DriverManager.getConnection("jdbc:mysql://localhost/sistemapp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT-6", "root", "30dpr4319n");
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        }
        return uniqueInstance;
    }


    /**
     * Cierra la conexión con la base de datos y asigna null al objeto
     * Connection.
     */
    public void closeConnection() {
        try {
            this.uniqueInstance.close();
            this.uniqueInstance = null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
