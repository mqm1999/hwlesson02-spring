package com.example.HWLesson02.helper;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseUtil {
    Connection connection = null;

    public DatabaseUtil() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
            return;
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Demo", "root", "123456");
        } catch (SQLException e) {
            System.out.println("Cant connect");
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean updateQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean closeConnection() {
        try {
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
