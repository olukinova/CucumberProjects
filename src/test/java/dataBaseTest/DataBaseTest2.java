package dataBaseTest;

import javax.xml.transform.Result;
import java.sql.*;

public class DataBaseTest2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for Batch 15");
            Statement statement = connection.createStatement();

            //ResultSet rset = statement.executeQuery("select FirstName, LastName from person");
             /*while(rset.next()) {
                String fName = rset.getString("FirstName"); // this is still not a good option since
                // firstname and lastname are hardcoded
                String lName = rset.getString("LastName");
                System.out.println(fName + " " + lName);
            }*/
            ResultSet rset = statement.executeQuery("Select firstname, lastname, age, city from person where city is not null");


            ResultSetMetaData metaData = rset.getMetaData();
            // print all columns header values
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
               String columnName = metaData.getColumnName(i);
                System.out.println(columnName);
            }

            System.out.println();

            // ResultSetMetaData - object that contains info about the result:
            // information such as how many objects are there, how many columns,
            // rows and number of rows in the table

// We want to loop through every column and every row
            while(rset.next()) {
               for (int i = 1; i <= metaData.getColumnCount(); i++) {
                   String value = rset.getString(metaData.getColumnName(i));
                   System.out.println(value + " ");
               }
               // just to change the line statement added below
                System.out.println();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
