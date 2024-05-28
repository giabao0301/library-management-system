/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.Issue;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import models.Book.Book;
import models.Student.Student;
import utils.DBConnection;
import java.util.Date;
import java.util.List;

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
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                LocalDate issueDate = rs.getDate("issue_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                String status = rs.getString("status");
                return new Issue(id, bookId, bookName, studentId, studentName, issueDate, dueDate, status);
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

    public boolean updateById(int issueId, String status) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update issue SET status = ?  where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, status);
            pst.setInt(2, issueId);

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

    public boolean deleteById(int issueId) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from issue where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, issueId);

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

    public List<Issue> findByStatus(String status) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "select * from issue where status = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, status);

            ResultSet rs = pst.executeQuery();

            List<Issue> issues = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                LocalDate issueDate = rs.getDate("issue_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();

                issues.add(new Issue(id, bookId, bookName, studentId, studentName, issueDate, dueDate, status));
            }

            return issues;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Issue> findViolatedIssueByStudentId(int studentId) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "select * from issue where student_id = ? and status in (?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, studentId);
            pst.setString(2, "Quá hạn");
            pst.setString(3, "Đã mất");

            ResultSet rs = pst.executeQuery();

            List<Issue> issues = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                LocalDate issueDate = rs.getDate("issue_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                String status = rs.getString("status");

                issues.add(new Issue(id, bookId, bookName, studentId, studentName, issueDate, dueDate, status));
            }

            return issues;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Issue findViolatedIssueByBookIdAndStudentId(String bookId, int studentId) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "select * from issue where student_id = ? and book_id = ? and status in (?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, studentId);
            pst.setString(2, bookId);
            pst.setString(3, "Quá hạn");
            pst.setString(4, "Đã mất");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                LocalDate issueDate = rs.getDate("issue_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                String status = rs.getString("status");

                return new Issue(id, bookId, bookName, studentId, studentName, issueDate, dueDate, status);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Issue> findAllViolatedIssue() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "select * from issue where status in (?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, "Quá hạn");
            pst.setString(2, "Đã mất");

            ResultSet rs = pst.executeQuery();

            List<Issue> issues = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                LocalDate issueDate = rs.getDate("issue_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                String status = rs.getString("status");

                issues.add(new Issue(id, bookId, bookName, studentId, studentName, issueDate, dueDate, status));
            }

            return issues;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Issue> findAll() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "select * from issue";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            List<Issue> issues = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                LocalDate issueDate = rs.getDate("issue_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                String status = rs.getString("status");

                issues.add(new Issue(id, bookId, bookName, studentId, studentName, issueDate, dueDate, status));
            }

            return issues;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Issue> findAllBetweenDates(Date dateFrom, Date dateTo) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue where issue_date BETWEEN ? AND ?";
            PreparedStatement pst = con.prepareStatement(sql);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String sDateFrom = formatter.format(dateFrom);
            String sDateTo = formatter.format(dateTo);
            
            pst.setString(1, sDateFrom);
            pst.setString(2, sDateTo);

            ResultSet rs = pst.executeQuery();

            List<Issue> issues = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                LocalDate issueDate = rs.getDate("issue_date").toLocalDate();
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                String status = rs.getString("status");

                issues.add(new Issue(id, bookId, bookName, studentId, studentName, issueDate, dueDate, status));

            }
            return issues;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
