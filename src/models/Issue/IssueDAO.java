/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.Issue;

import java.sql.*;
import models.Book.Book;
import models.Student.Student;
import utils.DBConnection;
import java.util.Date;

/**
 *
 * @author trinh
 */
public class IssueDAO {

    public IssueDAO() {
    }

    public Issue findByBookIdAndStudentId(String bookId, int studentId) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "Đang mượn");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String bookName = rs.getString("bookName");
                String studentName = rs.getString("studentName");
                return new Issue(id, bookName, studentName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addIssue(Book book, Student student, Date issueDate, Date dueDate) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue (book_id, book_name, student_id, student_name, issue_date, due_date, status)"
                    + "values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, book.getId());
            pst.setString(2, book.getTitle());
            pst.setInt(3, student.getId());
            pst.setString(4, student.getName());
            pst.setDate(5, new java.sql.Date(issueDate.getTime()));
            pst.setDate(6, new java.sql.Date(dueDate.getTime()));
            pst.setString(7, "Đang mượn");

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
