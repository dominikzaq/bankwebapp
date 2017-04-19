package com.pkproject.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by domin on 19.04.17.
 */
public class DataConnect {
    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/Emp","root","root");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close() {
        try {
            connect().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
