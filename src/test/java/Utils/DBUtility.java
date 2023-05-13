package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {

    static Connection connection = null;
    static Statement statement = null;

    private static ResultSet rset;
    private static ResultSetMetaData rsetMetadata;

    // this method creates connection to the DB, it will execute query and return object for results
    public static ResultSet getResultSet (String sqlQuery) {

        try {
            connection = DriverManager.getConnection(
                    ConfigReader.getPropertyValue("urlDB"),
                    ConfigReader.getPropertyValue("usernameDB"),
                    ConfigReader.getPropertyValue("passwordDB"));

            statement = connection.createStatement();
            rset = statement.executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rset;
    }

    // this method will return the object of rsetMetaData

    public static  ResultSetMetaData getRsetMetadata (String query) {

        rset = getResultSet(query);
        rsetMetadata = null; // we're making it as null since
        // we use this line to get the data in tabular format so that we can use these
        // in column keys and values for retrieval operation
        try {
            rsetMetadata = rset.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsetMetadata;
    }

    // this method extracts the data which will be stored in list of maps

    public static List<Map<String, String>> getListOfMapsFromRSet(String query) {

        rsetMetadata = getRsetMetadata(query);
        List<Map<String, String>> listFromSet = new ArrayList<>();

        try {
            while (rset.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                for (int i = 1; i <= rsetMetadata.getColumnCount(); i++) {
                    // fetching key and value from the columns
                    String key = rsetMetadata.getColumnName(i); // this is how we can get keys
                    String value = rset.getString(key); // this is how we can get values
                    map.put(key, value); // putting key and value to the Map
                }
                System.out.println(map);
                listFromSet.add(map); // updating list of maps with a new map
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeResult(rset);
            DBUtility.closeStatement(statement);
            DBUtility.closeConnection(connection);
        }
        return  listFromSet;
    }

    // Order:
    // - connection
    // - statement
    // - resultset

    // The first thing that have to be closed is resultset, then statement should be closed
    // and only after that the connection should be closed

    public static void closeResult(ResultSet rset) {
        if(rset != null) {
            try {
                rset.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement (Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection (Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
