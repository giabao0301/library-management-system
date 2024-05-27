/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.Penalty;

import java.sql.*;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnection;

/**
 *
 * @author trinh
 */
public class PenaltyDAO {

    public PenaltyDAO() {

    }

    public boolean addPenalty(Penalty penalty) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into penalty (student_id, student_name, book_id, book_name, penalty_amount, penalty_date)"
                    + "values(?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, penalty.getStudentId());
            pst.setString(2, penalty.getStudentName());
            pst.setString(3, penalty.getBookId());
            pst.setString(4, penalty.getBookName());
            pst.setInt(5, penalty.getPenaltyAmount());
            pst.setDate(6, java.sql.Date.valueOf(penalty.getPenaltyDate()));

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

    public List<Penalty> findAll() {
        List<Penalty> penalties = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from penalty";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                int penaltyAmount = rs.getInt("penalty_amount");
                LocalDate penaltyDate = rs.getDate("penalty_date").toLocalDate();

                penalties.add(new Penalty(id, bookId, bookName, studentId, studentName, penaltyAmount, penaltyDate));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return penalties;
    }
    
    public Penalty findByStudentIdAndBookId(String bookId, int studentId) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from penalty where book_id = ? and student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, bookId);
            pst.setInt(2, studentId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String studentName = rs.getString("student_name");
                String bookName = rs.getString("book_name");
                int penaltyAmount = rs.getInt("penalty_amount");
                LocalDate penaltyDate = rs.getDate("penalty_date").toLocalDate();

                return new Penalty(id, bookId, bookName, studentId, studentName, penaltyAmount, penaltyDate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
