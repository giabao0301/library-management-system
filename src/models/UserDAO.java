/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import utils.DBConnection;
import views.LoginForm;

/**
 *
 * @author trinh
 */
public class UserDAO {

    public UserDAO() {
        
    }

    public boolean addUser(User user) {
        try {
            Connection connect = DBConnection.getConnection();
            String sql = "insert into users(name, password, email, phone) values(?, ?, ?, ?)";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, user.getName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPhone());

            int updatedRowCount = pst.executeUpdate();

            if (updatedRowCount > 0) {
                return true;
            }

            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return false;
    }

    public User findByUserName(String userName) {
        User user = new User();

        try {
            Connection connect = DBConnection.getConnection();
            String sql = "select * from users where name = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, userName);

            ResultSet result = pst.executeQuery();

            if (result.next()) {
                user = new User(result.getString("name"), result.getString("password"), result.getString("email"), result.getString("phone"));
            } else {
                user = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
