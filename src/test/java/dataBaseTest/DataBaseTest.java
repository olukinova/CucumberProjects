package dataBaseTest;

import io.cucumber.plugin.event.Result;

import java.sql.*;

public class DataBaseTest {

    // to build the connection with the DB we need:
    // - address of the database;
    //- proper name of a database;
    //- access to the database (credentials - username and password)

    public static void main(String[] args) {
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        // We need to establish connection to the DB
        try {
         Connection connection =  DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for Batch 15");
            // Create a statement to send sql queries
            Statement statement = connection.createStatement();
            // Now we are in a position to execute our queries
            // When we send any queries to the DB then DB returns results set (tables with rows and columns)
            ResultSet rset = statement.executeQuery("select FirstName, LastName from person");
            rset.next();
            String fName = rset.getString("FirstName");
            String lName = rset.getString("LastName");
            System.out.println(fName + " " + lName);

            // To print a second set of value
            rset.next();
            fName = rset.getString("FirstName");
            lName = rset.getString("LastName");
            System.out.println(fName + " " + lName);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
