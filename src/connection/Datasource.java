package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Datasource {
    
    public static String JSBCURL = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Jakarta";
    public static String PASSWORD = "allia_azahra";
    public static String USERNAME = "root";

    public static Connection getConnection() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection(JSBCURL, USERNAME, PASSWORD);
            System.out.println("success connect!");
            return connection;
        } catch (SQLException SQLEX) {
          System.out.println(SQLEX.getMessage());
          return null;
        }
    }
}
