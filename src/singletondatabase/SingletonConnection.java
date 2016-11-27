package singletondatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonConnection {
    
    private static SingletonConnection instance = null;
    String URL = "jdbc:mysql://127.0.0.1/addressbook?user=root&password=haslo";
    Connection conn;
    Statement st;
    
    private SingletonConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL);
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    public static SingletonConnection getInstance(){
        if(instance == null){
            instance = new SingletonConnection();
        }
        return instance;
    }
    
    ResultSet executeQuery(String query){
        try {
            return  st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } 
    
    int executeUpdate(String query){
        try {
            return st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    
}
