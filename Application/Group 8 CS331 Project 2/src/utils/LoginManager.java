package utils;

import core.Queries;
import data.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginManager {
    private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        try {
            user.setId(rs.getInt("userID"));
            user.setName(rs.getString("Username"));
            user.setPass(rs.getString("Password"));
        }catch (SQLException ex){
            System.out.println("User or pass incorrect");
            ex.printStackTrace();
            return null;
        }
        return user;

    }

    private static User getUserPass() throws IOException {
        User user = new User();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Username: \n");
        user.setName( reader.readLine());
        System.out.println("Password: \n");
        user.setPass(reader.readLine());

        return user;
    }

    public static User getUserByUserNameAndPassword(String user, String pass) throws SQLException {
        ConnectionManager connector = new ConnectionManager();
        Connection connection = connector.createConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(Queries.USER_PASS.getString());
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return null;
    }
}
