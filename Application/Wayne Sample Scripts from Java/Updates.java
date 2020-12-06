package com.company;

import com.mysql.cj.protocol.Resultset;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Updates {
    private String username = "wayne";
    private String password = "password";
    Scanner keyInput = new Scanner(System.in);

    public void run(Connection conn)
    {
        System.out.print("Enter User ID:");
        username = readLine();
        System.out.print("Enter Password:");
        password = readLine();

        try {
            if(checkUserPassword(username, password, conn))
            {
                boolean done = false;
                do {
                    //Print MENU for INSERT / DELETE / UPDATE
                    printUpdatesOptions();
                    System.out.print("Type in your option: ");
                    System.out.flush();
                    String ch = readLine();
                    System.out.println();
                    switch (ch.charAt(0)) {
                        case 'A': case'a':
                                runAdd(conn);
                            break;
                        case 'B': case'b':
                                runDelete(conn);
                            break;
                        case 'C': case'c':
                                runUpdate(conn);
                            break;
                        case 'Q': case'q':
                            done = true;
                            System.out.println("Returning to Main Menu....");
                            break;
                        default:
                            System.out.println("NOT VALID OPTION!!!");
                    } //switch
                } while (!done);
            }
            else
            {
                System.out.println("Username or Password is Incorrect");
            }
        }catch (SQLException ex) {
            System.out.println(ex);
        }

    }// END OF RUN

//***********ALL ADD FUNCTIONS **********************
    private void runAdd(Connection conn)
    {
        try {
            boolean done = false;
            do {
                //Print MENU for INSERT / DELETE / UPDATE
                printOptionMenu("ADD");
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = readLine();
                System.out.println();
                switch (ch.charAt(0)) {
                    case '1':
                        addEquiptment(conn);
                        break;
                    case '2':
                        addService(conn);
                        break;
                    case '3':
                        addCustomerInfo(conn);
                        break;
                    case '4':
                        addEmployeeInfo(conn);
                        break;
                    case '5':
                        done = true;
                        System.out.println("Returning to Previous Menu....");
                        break;
                    default:
                        System.out.println("NOT VALID OPTION!!!");
                } //switch
            } while (!done);

        }catch (SQLException ex) {
            System.out.println(ex); }
    }
    private void addEquiptment(Connection conn) throws SQLException
    {
        //Get BrandName, Description, PurchasePrice(double), Type,
        String brandName, description, type;
        double price;
        int maxID = 0;
        System.out.print("New Equiptment Brand Name: ");
        brandName = readLine();
        System.out.print("New Equiptment Description: ");
        description = readLine();
        System.out.print("New Equiptment Purchase Price: ");
        try {
            price = keyInput.nextDouble();
        }catch(Exception e)
        {
            System.out.println("Input Invalid Back to Option Menu!");
            keyInput.next();
            return;
        }
        System.out.print("New Equiptment Type: ");
        type = readLine();

        /*brandName = "Good Year"; description = "I am very lazy to think of a good Description";
        type = "dryer"; price = 998.99;
        System.out.print("New Equiptment Brand Name: " + brandName);
        System.out.print("New Equiptment Description: " + description);
        System.out.print("New Equiptment Purchase Price: " + price);
        System.out.print("New Equiptment Type: " + type);*/

        String query = "SELECT MAX(InventoryID) FROM Inventory";
        Statement selectStatement = conn.createStatement();
        ResultSet rset = selectStatement.executeQuery(query);
        if(rset.next())
        {
            maxID = rset.getInt(1); maxID++;
            System.out.println("MaxID: " + maxID);
            String query1 = "INSERT INTO Inventory(InventoryID, InventoryCategory) VALUES ("+ maxID + ", 'X')";
            int result = selectStatement.executeUpdate(query1);

            String query2 = "INSERT INTO Equipment (EquipmentID, InventoryID, BrandName, Description, PurchaseDate, PurchasePrice, Type, HoursUsed, EquipmentMaintenanceScheduleID) SELECT MAX(EquipmentID) + 1, "+ maxID +", '"+ brandName + "', '" + description + "', CURDATE(), " + price + ", '" + type + "', 0, 2 FROM Equipment";
            int resu = selectStatement.executeUpdate(query2);
            System.out.println("Result: " + resu);
        }
    }
    private void addService(Connection conn) throws SQLException
    {

        //Get ServiceName, Description, RateCharge, Duration
        String serviceName, description, duration;
        double rateCharge;
        System.out.print("New Service Name: ");
        serviceName = readLine();
        System.out.print("New Service Description: ");
        description = readLine();
        System.out.print("New Service Rate Charge: ");
        try {
            rateCharge = keyInput.nextDouble();
        }catch(Exception e)
        {
            System.out.println("Input Invalid Back to Option Menu!");
            keyInput.next();
            return;
        }
        System.out.print("New Service Duration: ");
        duration = readLine();
        /*System.out.print("New Service Name: " + serviceName);
        System.out.print("New Service Description: " + description);
        System.out.print("New Service Rate Charge: " + rateCharge);
        System.out.print("New Service Duration: " + duration);*/

        String query = "INSERT INTO Service SELECT MAX(ServiceID) + 1, '" + serviceName + "', '" + description + "', " + rateCharge +", '" + duration + "' FROM Service";
        Statement selectStatement = conn.createStatement();
        int rset = selectStatement.executeUpdate(query);
        if(rset > 0)
        {
            System.out.println("New Service Added.");
        }
        else
        {
            System.out.println("Fail to Add New Service!");
        }
    }
    private void addCustomerInfo(Connection conn) throws SQLException
    {
        //Get FirstName, LastName, Address, Email, Phone, Balance
        String firstName, lastName, address, email, phone;
        double balance;
        System.out.print("New Customer First Name: ");
        firstName = readLine();
        System.out.print("New Customer Second Name: ");
        lastName = readLine();
        System.out.print("New Customer Address: ");
        address = readLine();
        System.out.print("New Customer Email: ");
        email = readLine();
        System.out.print("New Customer Phone Number: ");
        phone = readLine();
        System.out.print("New Customer Balance: ");
        try {
            balance = keyInput.nextDouble();
        }catch(Exception e)
        {
            System.out.println("Input Invalid Back to Option Menu!");
            keyInput.next();
            return;
        }
        String query = "INSERT INTO Customer SELECT MAX(CustomerID) + 1, '" + firstName + "', '" + lastName + "', '" + address + "', '" + email + "', '" + phone + "', " + balance + " FROM Customer";
        Statement selectStatement = conn.createStatement();
        int rset = selectStatement.executeUpdate(query);
        if(rset > 0)
        {
            System.out.println("New Customer Added.");
        }
        else
        {
            System.out.println("Fail to Add New Customer!");
        }
    }
    private void addEmployeeInfo(Connection conn) throws SQLException
    {
        //Get FirstName, LastName, Address, Gender, Position
        String firstName, lastName, address, gender;
        int position;
        System.out.print("New Employee First Name: ");
        firstName = readLine();
        System.out.print("New Employee Second Name: ");
        lastName = readLine();
        System.out.print("New Employee Address: ");
        address = readLine();
        System.out.print("New Employee Gender: ");
        gender   = readLine();
        System.out.print("New Employee Position: ");
        try {
            position = keyInput.nextInt();
        }catch(Exception e)
        {
            System.out.println("Input Invalid Back to Option Menu!");
            keyInput.next();
            return;
        }
        String query = "INSERT INTO Employee SELECT MAX(EmployeeID) + 1, '" + firstName + "', '" + lastName + "', '" + address + "', '" + gender + "', CURDATE(), " + position + " FROM Employee;";
        Statement selectStatement = conn.createStatement();
        int rset = selectStatement.executeUpdate(query);
        if(rset > 0)
        {
            System.out.println("New Employee Added.");
        }
        else
        {
            System.out.println("Fail to Add New Employee!");
        }
    }

//*********** ALL DELETE FUNCTIONS ************************
    private void runDelete(Connection conn)
    {
        try {
            boolean done = false;
            do {
                //Print MENU for INSERT / DELETE / UPDATE
                printOptionMenu("DELETE");
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = readLine();
                System.out.println();
                switch (ch.charAt(0)) {
                    case '1':
                        deleteEquiptment(conn);
                        break;
                    case '2':
                        deleteService(conn);
                        break;
                    case '3':
                        deleteCustomerInfo(conn);
                        break;
                    case '4':
                        deleteEmployeeInfo(conn);
                        break;
                    case '5':
                        done = true;
                        System.out.println("Returning to Previous Menu....");
                        break;
                    default:
                        System.out.println("NOT VALID OPTION!!!");
                } //switch
            } while (!done);

        }catch (SQLException ex) {
            System.out.println(ex); }
    }
    private void deleteEquiptment(Connection conn) throws SQLException
    {
        //Get Equipment ID
        int id;
        System.out.print("DELETE Equipment ID: ");
        try {
            id = keyInput.nextInt();
        }catch(Exception e)
        {
            System.out.println("Input Invalid Back to Option Menu!");
            keyInput.next();
            return;
        }
        String query = "SELECT EquipmentID FROM Equipment WHERE EquipmentID = " + id;
        Statement selectStatement = conn.createStatement();
        ResultSet rset = selectStatement.executeQuery(query);
        if(rset.next())
        {
            System.out.println("Equipment ID " + id + " Found.");
            String dquery = "DELETE FROM Equipment WHERE EquipmentID = " + id;
            int rseti = selectStatement.executeUpdate(dquery);
            if(rseti > 0)
                System.out.println("Equipment ID " + id + " Deleted.");
        }
        else
        {
            System.out.println("Equipment ID " + id + " Not Found!");
        }
    }
    private void deleteService(Connection conn) throws SQLException
    {
        //Get Equipment ID
        int id;
        System.out.print("DELETE Service ID: ");
        try {
            id = keyInput.nextInt();
        }catch(Exception e)
        {
            System.out.println("Input Invalid Back to Option Menu!");
            keyInput.next();
            return;
        }
        String query = "SELECT ServiceID FROM Service WHERE ServiceID = " + id;
        Statement selectStatement = conn.createStatement();
        ResultSet rset = selectStatement.executeQuery(query);
        if(rset.next())
        {
            System.out.println("Service ID " + id + " Found.");
            String dquery = "DELETE FROM Service WHERE ServiceID = " + id;
            int rseti = selectStatement.executeUpdate(dquery);
            if(rseti > 0)
                System.out.println("Service ID " + id + " Deleted.");
        }
        else
        {
            System.out.println("Service ID " + id + " Not Found!");
        }
    }
    private void deleteCustomerInfo(Connection conn) throws SQLException
    {
        //Get Equipment ID
        int id;
        System.out.print("DELETE Customer ID: ");
        try {
            id = keyInput.nextInt();
        }catch(Exception e)
        {
            System.out.println("Input Invalid Back to Option Menu!");
            keyInput.next();
            return;
        }
        String query = "SELECT CustomerID FROM Customer WHERE CustomerID = " + id;
        Statement selectStatement = conn.createStatement();
        ResultSet rset = selectStatement.executeQuery(query);
        if(rset.next())
        {
            System.out.println("Customer ID " + id + " Found.");
            String dquery = "DELETE FROM Customer WHERE CustomerID = " + id;
            int rseti = selectStatement.executeUpdate(dquery);
            if(rseti > 0)
                System.out.println("Customer ID " + id + " Deleted.");
        }
        else
        {
            System.out.println("Customer ID " + id + " Not Found!");
        }
    }
    private void deleteEmployeeInfo(Connection conn) throws SQLException
    {
        //Get Employee ID
        int id;
        System.out.print("DELETE Employee ID: ");
        try {
            id = keyInput.nextInt();
        }catch(Exception e)
        {
            System.out.println("Input Invalid Back to Option Menu!");
            keyInput.next();
            return;
        }
        String query = "SELECT EmployeeID FROM Employee WHERE EmployeeID = " + id;
        Statement selectStatement = conn.createStatement();
        ResultSet rset = selectStatement.executeQuery(query);
        if(rset.next())
        {
            System.out.println("Employee ID " + id + " Found.");
            String dquery = "DELETE FROM Employee WHERE EmployeeID = " + id;
            int rseti = selectStatement.executeUpdate(dquery);
            if(rseti > 0)
                System.out.println("Employee ID " + id + " Deleted.");
        }
        else
        {
            System.out.println("Employee ID " + id + " Not Found!");
        }
    }
//*********** ALL UPDATE FUNCTIONS ******************************
    private void runUpdate(Connection conn)
    {
        try {
                boolean done = false;
                do {
                    //Print MENU for INSERT / DELETE / UPDATE
                    printOptionMenu("UPDATE");
                    System.out.print("Type in your option: ");
                    System.out.flush();
                    String ch = readLine();
                    System.out.println();
                    switch (ch.charAt(0)) {
                        case '1':
                            updateEquiptment(conn);
                            break;
                        case '2':
                            updateService(conn);
                            break;
                        case '3':
                            updateCustomerInfo(conn);
                            break;
                        case '4':
                            updateEmployeeInfo(conn);
                            break;
                        case '5':
                            done = true;
                            System.out.println("Returning to Previous Menu....");
                            break;
                        default:
                            System.out.println("NOT VALID OPTION!!!");
                    } //switch
                } while (!done);

            }catch (SQLException ex) {
                System.out.println(ex); }
    }
    private void updateEquiptment(Connection conn) throws SQLException
    {
        //Get Equipment ID
        int id;
        System.out.print("UPDATE Equipment ID: ");
        try {
            id = keyInput.nextInt();
        }catch(Exception e)
        {
            System.out.println("Input Invalid Back to Option Menu!");
            keyInput.next();
            return;
        }
        String query = "SELECT * FROM Equipment WHERE EquipmentID = " + id;
        Statement selectStatement = conn.createStatement();
        ResultSet rset = selectStatement.executeQuery(query);
        if(rset.next())
        {
            System.out.println("Equipment ID " + id + " Found.");
            System.out.println("Brand Name: " + rset.getString(3));
            System.out.println("Description: " + rset.getString(4));
            System.out.println("Price: " + rset.getString(6));
            System.out.println("HourUsed: " + rset.getString(8));
            System.out.println("Maintenance: " + rset.getString(9));

            String brandName, description, type;
            double hourUsed;
            int schecule;
            System.out.print("UPDATE Equipment Brand Name: ");
            brandName = readLine();
            System.out.print("UPDATE Equipment Description: ");
            description = readLine();
            System.out.print("UPDATE Equipment Hours Used: ");
            try {
                hourUsed = keyInput.nextDouble();
            }catch(Exception e)
            {
                System.out.println("Input Invalid Back to Option Menu!");
                keyInput.next();
                return;
            }
            System.out.print("UPDATE Equipment Maintenance Schedule: ");
            try {
                schecule = keyInput.nextInt();
            }catch(Exception e)
            {
                System.out.println("Input Invalid Back to Option Menu!");
                keyInput.next();
                return;
            }
            String updateQuery = "UPDATE Equipment SET BrandName = '" + brandName + "', Description = '" + description +"', HoursUsed = " + hourUsed + ", EquipmentMaintenanceScheduleID = " + schecule + " WHERE EquipmentID = "  + id;
            int rsetu = selectStatement.executeUpdate(updateQuery);

            if(rsetu > 0)
                System.out.println("Equipment ID " + id + " Updated.");
            else
                System.out.println("Fail to UPDATE New Service!");

        }
        else
        {
            System.out.println("Equipment ID " + id + " Not Found!");
        }
    }
    private void updateService(Connection conn) throws SQLException
    {
        int id;
        System.out.print("UPDATE Service ID: ");
        try {
            id = keyInput.nextInt();
        }catch(Exception e)
        {
            System.out.println("Input Invalid Back to Option Menu!");
            keyInput.next();
            return;
        }
        String query = "SELECT * FROM Service WHERE ServiceID = " + id;
        Statement selectStatement = conn.createStatement();
        ResultSet rset = selectStatement.executeQuery(query);
        if(rset.next())
        {

            System.out.println("Service ID " + id + " Found.");
            System.out.println("Service Name: " + rset.getString(2));
            System.out.println("Description: " + rset.getString(3));
            System.out.println("Rate Charge: " + rset.getDouble(4));
            System.out.println("Duration: " + rset.getString(4));

            String serviceName, description, duration;
            double rateCharge;
            System.out.print("UPDATE Service Name: ");
            serviceName = readLine();
            System.out.print("UPDATE Service Description: ");
            description = readLine();
            System.out.print("UPDATE Service Rate Charge: ");
            try {
                rateCharge = keyInput.nextDouble();
            }catch(Exception e)
            {
                System.out.println("Input Invalid Back to Option Menu!");
                keyInput.next();
                return;
            }
            System.out.print("UPDATE Service Duration: ");
            duration = readLine();

            String uquery = "UPDATE Service SET ServiceName = '" + serviceName + "', Description = '" + description + "', RateCharge = " + rateCharge + " , Duration = '" + duration + "' WHERE ServiceID = " + id;

            int rsetu = selectStatement.executeUpdate(uquery);
            if(rsetu > 0)
            {
                System.out.println("Service ID: " + id  + " UPDATED! :D.");
            }
            else
            {
                System.out.println("Fail to UPDATE New Service!");
            }
        }
        else
        {
            System.out.println("Service ID " + id + " Not Found!");
        }
    }
    private void updateCustomerInfo(Connection conn) throws SQLException
    {
        //Get Equipment ID
        int id;
        System.out.print("UPDATE Customer ID: ");
        try {
            id = keyInput.nextInt();
        }catch(Exception e)
        {
            System.out.println("Input Invalid Back to Option Menu!");
            keyInput.next();
            return;
        }
        String query = "SELECT * FROM Customer WHERE CustomerID = " + id;
        Statement selectStatement = conn.createStatement();
        ResultSet rset = selectStatement.executeQuery(query);
        if(rset.next())
        {
            System.out.println("Customer ID " + id + " Found.");
            System.out.println("First Name: " + rset.getString(2));
            System.out.println("Last Name: " + rset.getString(3));
            System.out.println("Address: " + rset.getString(4));
            System.out.println("Email: " + rset.getString(5));
            System.out.println("Phone Number: " + rset.getString(6));
            System.out.println("Balance: " + rset.getDouble(7));

            String firstName, lastName, address, email, phone;
            double balance;
            System.out.print("UPDATE Customer First Name: ");
            firstName = readLine();
            System.out.print("UPDATE Customer Second Name: ");
            lastName = readLine();
            System.out.print("UPDATE Customer Address: ");
            address = readLine();
            System.out.print("UPDATE Customer Email: ");
            email = readLine();
            System.out.print("UPDATE Customer Phone Number: ");
            phone = readLine();
            System.out.print("UPDATE Customer Balance: ");
            try {
                balance = keyInput.nextDouble();
            }catch(Exception e)
            {
                System.out.println("Input Invalid Back to Option Menu!");
                keyInput.next();
                return;
            }
            String uquery = "UPDATE Customer SET FirstName = '" +  + " ', LastName = '', Address = '', Email = '', PhoneNumber = '', Balance = 123 WHERE ServiceID = " + id;
            int rsetu = selectStatement.executeUpdate(uquery);
            if(rsetu > 0)
                System.out.println("Customer ID " + id + " UPDATED :D");
            else
                System.out.println("Fail to UPDATE New Customer!");

        }
        else
        {
            System.out.println("Customer ID " + id + " Not Found!");
        }
    }
    private void updateEmployeeInfo(Connection conn) throws SQLException
    {
        System.out.println("updateing Employee Form!");
    }

    private void printUpdatesOptions(){
        System.out.println("\n*****************************************************************************");
        System.out.println("                       **********************");
//        System.out.println("                     Welcome to Clean-and-Go Shop");
        System.out.println("               Menu 4. UPDATES. Current User: " + username);
        System.out.println("                       **********************");
        System.out.println("*****************************************************************************");
        System.out.println("                     A. Insert New Information.");
        System.out.println("                     B. Delete Some Information.");
        System.out.println("                     C. Update Current Information.");
        System.out.println("                           Q. Quit");
    }
    private void printOptionMenu(String option)
    {
        System.out.println("\n*****************************************************************************");
        System.out.println("                       **********************");
//        System.out.println("                     Welcome to Clean-and-Go Shop");
        System.out.println("               Menu 4. UPDATES. Current User: " + username);
        System.out.println("                        Sub Option: " + option);
        System.out.println("                       **********************");
        System.out.println("*****************************************************************************");
        System.out.println("                     1. " + option + " Equipment");
        System.out.println("                     2. " + option + " Service");
        System.out.println("                     3. " + option + " Customer Information");
        System.out.println("                     4. " + option + " Employee Information");
        System.out.println("                           5. Quit");
    }

    private boolean checkUserPassword (String username, String password, Connection conn) throws SQLException
    {
        String query = "SELECT * FROM User WHERE Username = '" + username + "' AND Password = '" + password + "';";
        Statement selectStatement = conn.createStatement();
        ResultSet rset = selectStatement.executeQuery(query);
        if(rset.next())
        {
            System.out.println("LOGIN SUCCESS :D");
            return true;
        }
        else
        {
            return false;
        }
    }

    private static String readLine() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr, 1);
        String line = "";

        try {
            line = br.readLine();
        } catch (IOException e) {
            System.out.println("Error in SimpleIO.readLine: " +
                    "IOException was thrown");
            System.exit(1);
        }
        return line;
    }
}// End of Updates CLASS
