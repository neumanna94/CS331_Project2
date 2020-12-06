/*
 *@author Mac DeCourcy
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private final String driverName = "com.mysql.cj.jdbc.Driver";
    private final String connectionUrl = "jdbc:mysql://localhost:3306/CleanAndGo";
    private final String userName = "student";
    private final String userPass = "password";

    private Connection con = null;

    public ConnectionManager() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public Connection createConnection() {
        try {
            con = DriverManager.getConnection(connectionUrl, userName, userPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection() {
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}