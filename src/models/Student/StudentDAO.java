/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.Student;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import utils.DBConnection;

/**
 *
 * @author trinh
 */
public class StudentDAO {

    public StudentDAO() {

    }

    public List<Student> findAllStudents() {
        List<Student> students = new ArrayList<>();

        try {
            Connection connect = DBConnection.getConnection();
            String sql = "select * from student";
            PreparedStatement pst = connect.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                String email = rs.getString("email");
                String major = rs.getString("major");
                
                students.add(new Student(id, name, gender, birthday, email, major));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public boolean addStudent(Student student) {
        try {
            Connection connect = DBConnection.getConnection();

            String sql = "INSERT INTO student ( id, name, gender, birthday, email, major )VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setInt(1, student.getId());
            pst.setString(2, student.getName());
            pst.setString(3, student.getGender());
            pst.setDate(4, java.sql.Date.valueOf(student.getBirthday()));
            pst.setString(5, student.getEmail());
            pst.setString(6, student.getMajor());

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

    public boolean deleteById(int studentId) {
        try {
            Connection connect = DBConnection.getConnection();

            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setInt(1, studentId);

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

    public boolean updateStudent(Student student) {
        try {
            Connection connect = DBConnection.getConnection();

            String sql = "UPDATE student SET id = ?, name = ?, gender = ?, birthday = ?, email = ?, major = ?, is_banned = ? WHERE id = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setInt(1, student.getId());
            pst.setString(2, student.getName());
            pst.setString(3, student.getGender());
            pst.setDate(4, java.sql.Date.valueOf(student.getBirthday()));
            pst.setString(5, student.getEmail());
            pst.setString(6, student.getMajor());
            pst.setInt(7, student.getIsBanned());
            pst.setInt(8, student.getId());

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

    public Student findById(int studentId) {
        Student student = new Student();

        try {
            Connection connect = DBConnection.getConnection();
            String sql = "select * from student where id = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setInt(1, studentId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                String email = rs.getString("email");
                String major = rs.getString("major");
                int isBanned = rs.getInt("is_banned");
                
                student = new Student(id, name, gender, birthday, email, major, isBanned);
            } else {
                student = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public List<String> findAllMajors() {
        List<String> majors = new ArrayList<>();

        try {
            Connection connect = DBConnection.getConnection();

            String sql = "SELECT DISTINCT major FROM `student` WHERE 1";

            PreparedStatement pst = connect.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                majors.add(rs.getString("major"));
            }

            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }

        return majors;
    }

    public List<Student> findAllByMajor(String studentMajor) {
        List<Student> students = new ArrayList<>();

        try {
            Connection connect = DBConnection.getConnection();
            String sql = "select * from student where major = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, studentMajor);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                String email = rs.getString("email");
                String major = rs.getString("major");

                students.add(new Student(id, name, gender, birthday, email, major));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

}
