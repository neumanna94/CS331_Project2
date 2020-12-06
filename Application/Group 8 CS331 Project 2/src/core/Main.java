/*
*@author Mac DeCourcy
* TODO: Dynamic response method
*/
package core;

import menu.*;
import utils.*;
import data.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {

    public static Menu menu = new Menu(0);

    public static void main(String[] args){
        populateMenu();
        menu.menuLoop();
        System.exit(0);
    }

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

    public ResultSet queryToResultSet(Queries query) throws SQLException {
        ConnectionManager connector = new ConnectionManager();
        Connection connection = connector.createConnection();
        String queryString = query.getString();
        ResultSet rset;
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            rset = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("[ERROR] QUERY COULD NOT BE EXECUTED ");
            while (e != null) {
                System.out.println("Message :" + e.getMessage());
                e = e.getNextException();
            }
            connection.close();
            return null;
        }
        connection.close();
        return rset;
    }

    public static void populateMenu(){

        System.out.println("CLEAN N GO MENU");

        Menu equipAndSupplies = new Menu(1);
        Menu custAndServices = new Menu(1);
        Menu employees = new Menu(1);
        Menu updates = new Menu(1);
        Menu debug = new Menu(1);

        equipAndSupplies.add(new MenuOption("1", "Add new equipment") {
            @Override
            public void doAction() {}
        });
        equipAndSupplies.add(new MenuOption("2", "Add new supply") {
            @Override
            public void doAction() {}
        });
        equipAndSupplies.add(new MenuOption("3", "View Inventory") {
            @Override
            public void doAction() {}
        });
        equipAndSupplies.add(new MenuOption("0", "Quit") {
            @Override
            public void doAction() { }
        });
        custAndServices.add(new MenuOption("1", "Analyze the progress of the business") {
            @Override
            public void doAction() {
                System.out.println("I'm in cust and services option 1");
            }
        });
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

        custAndServices.add(new MenuOption("0", "Quit") {
            @Override
            public void doAction() {
                System.out.println("Exiting...");
            }
        });

        employees.add(new MenuOption("1", "Display Schedules"){
            @Override
            public void doAction(){};
        });

        employees.add(new MenuOption("0", "Quit"){
            @Override
            public void doAction(){};
        });

        updates.add(new MenuOption("1", "Delete Equipment")
        {
            @Override
            public void doAction(){};
        });

        updates.add(new MenuOption("2", "Delete Service")
        {
            @Override
            public void doAction(){};
        });

        updates.add(new MenuOption("3", "Delete Customer")
        {
            @Override
            public void doAction(){};
        });

        updates.add(new MenuOption("4", "Delete Employee")
        {
            @Override
            public void doAction(){};
        });

        updates.add(new MenuOption("0", "Quit")
        {
            @Override
            public void doAction(){};
        });

        debug.add(new MenuOption("1", "Test conn") {
            @Override
            public void doAction() throws SQLException {
            }
        });

        debug.add(new MenuOption("2", "Test login") {
            @Override
            public void doAction() throws SQLException, IOException {
                User x = getUserPass();
                User user = getUserByUserNameAndPassword(x.getName(), x.getPass());
                if(user == null)
                    System.out.println("user pass incorrect try again");
                else
                    System.out.println("Great success");
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
        menu.add(new MenuOption("3","Employees") {
            @Override
            public void doAction() {
                System.out.println("Employees");
                employees.menuLoop();
            }
        });
        menu.add(new MenuOption("4","Updates") {
            @Override
            public void doAction() {
                System.out.println("Updates");
                updates.menuLoop();
            }
        });
        menu.add(new MenuOption("5", "debug") {
            @Override
            public void doAction() {
                debug.menuLoop();
            }
        });

    }
}
