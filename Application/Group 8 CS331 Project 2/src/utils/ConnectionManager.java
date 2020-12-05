package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private final String driverName = "com.mysql.jdbc.Driver";
    private final String connectionUrl = "jdbc:mysql://localhost:3306/student";
    private final String userName = "Mac";
    private final String userPass = "Daddy";

    private Connection con = null;

//    public ConnectionManager(String u, String p){
//        this.userName = u;
//        this.userPass = p;
//    }

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