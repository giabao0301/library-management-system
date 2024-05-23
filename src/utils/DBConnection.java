/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author trinh
 */
public class DBConnection {

    static Connection connect = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlythuvien", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connect;
    }
    
    public static void closeConnection() {
        try {
            connect.close();
            System.out.println("Database closed");
        } catch (SQLException e) {
            System.out.println("Cannot close connection");
        }
    }
}
