package com.company.connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyConnection {
    public java.sql.Connection connection;
    public MyConnection() {
        String userName = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/selection_committee";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(connectionURL, userName, "laserflip25");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }



}
