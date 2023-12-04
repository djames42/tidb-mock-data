package com.pingcap.se.database;

import com.pingcap.se.models.TestTable;
import com.pingcap.se.models.JsonExtensions;
import com.pingcap.se.services.GetProperties;

import java.sql.*;

public class Aurora {
    private Connection connection;
    private PreparedStatement preparedInsertStatement;

    public Aurora(String propFile) {
        GetProperties getProperties = new GetProperties(propFile);
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://" + getProperties.getProperties("db_host") + ":" + getProperties.getProperties("db_port") + "/" + getProperties.getProperties("db_database");
            String username=getProperties.getProperties("db_username");
            String password=getProperties.getProperties("db_password");
            Class.forName(myDriver).newInstance();
            connection = DriverManager.getConnection(myUrl, username, password);
            String insertQuery = "Insert into test_table(field1,field2,field3,field4,field5,field6) values (?, ?, ?, ?, ?, ?)";
            preparedInsertStatement = connection.prepareStatement(insertQuery);
        } catch (SQLException e) {
            System.err.println("Unknown SQL Exception");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.err.println("Class Not Found Exception");
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertRow(TestTable testTable) {
        try {
            preparedInsertStatement.setInt(1, testTable.getField1());
            preparedInsertStatement.setInt(2, testTable.getField2());
            preparedInsertStatement.setString(3, testTable.getField3());
            preparedInsertStatement.setFloat(4, testTable.getField4());
            preparedInsertStatement.setFloat(5, testTable.getField5());
            preparedInsertStatement.setObject(6, testTable.getField6().toString());
            preparedInsertStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
