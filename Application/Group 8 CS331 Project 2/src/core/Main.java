package core;

import menu.*;
import utils.*;
import data.User;

import java.sql.*;

public class Main {

    static Menu menu = new Menu();

    public static void main(String[] args){
        populateMenu();
        menu.menuLoop();
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId( rs.getInt("id") );
        user.setName( rs.getString("name") );
        user.setPass( rs.getString("pass") );
        return user;
    }

    public User getUserByUserNameAndPassword(String user, String pass) throws SQLException {
        ConnectionManager connector = new ConnectionManager();
        Connection connection = connector.createConnection();
    try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE Username = ? AND Password = ?");
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

    public static void populateMenu(){

        System.out.println("CLEAN N GO MENU");

        Menu equipAndSupplies = new Menu(1);
        Menu custAndServices = new Menu(1);

        custAndServices.add(new MenuOption("1", "Analyze the progress of the business") {
            @Override
            public void doAction() {
                System.out.println("I'm in cust and services option 1");
            }
        });

        custAndServices.add(new MenuOption("2", "Services") {
            @Override
            public void doAction() {
                System.out.println("I'm in cust and services option 2");
            }
        });

        custAndServices.add(new MenuOption("3", "Customers") {
            @Override
            public void doAction() {
                System.out.println("I'm in cust and services option 3");
            }
        });

        custAndServices.add(new MenuOption("0", "Exit") {
            @Override
            public void doAction() {
                System.out.println("Exiting...");
            }
        });

        menu.add(new MenuOption("1","Equipment & Supplies") {
            @Override
            public void doAction() {
                System.out.println("I'm in equipment and supplies");
                equipAndSupplies.menuLoop();
            }
        });

        menu.add(new MenuOption("2","Customers & Services") {
            @Override
            public void doAction() {
                System.out.println("Customers & Services");
                custAndServices.menuLoop();
            }
        });

    }
}
