/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnection;

/**
 *
 * @author trinh
 */
public class BookDAO {

    public BookDAO() {
    }

    public boolean addBook(Book book) {
        try {
            Connection connect = DBConnection.getConnection();

            String sql = "INSERT INTO book_details ( bookID, bookName, category, author, publisher, quantity, price )VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, book.getId());
            pst.setString(2, book.getName());
            pst.setString(3, book.getCategory());
            pst.setString(4, book.getAuthor());
            pst.setString(5, book.getPublisher());
            pst.setInt(6, book.getQuantity());
            pst.setInt(7, book.getPrice());

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

    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();

        try {
            Connection connect = DBConnection.getConnection();
            String sql = "select * from book_details";
            PreparedStatement pst = connect.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String bookID = rs.getString("bookID");
                String bookName = rs.getString("bookName");
                String category = rs.getString("category");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");

                books.add(new Book(bookID, bookName, category, author, publisher, quantity, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book findById(String bookId) {
        Book book = new Book();

        try {
            Connection connect = DBConnection.getConnection();
            String sql = "select * from book_details where bookId = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, bookId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String id = rs.getString("bookID");
                String name = rs.getString("bookName");
                String category = rs.getString("category");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");

                book = new Book(id, name, category, author, publisher, quantity, price);
            } else {
                book = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    public boolean deleteById(String id) {
        try {
            Connection connect = DBConnection.getConnection();

            String sql = "DELETE FROM book_details WHERE bookID = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, id);

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

    public boolean updateBook(Book book) {
        try {
            Connection connect = DBConnection.getConnection();

            String sql = "UPDATE book_details SET bookId = ?, bookName = ?, category = ?, author = ?, publisher = ?, quantity = ?, price = ? WHERE bookId = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, book.getId());
            pst.setString(2, book.getName());
            pst.setString(3, book.getCategory());
            pst.setString(4, book.getAuthor());
            pst.setString(5, book.getPublisher());
            pst.setInt(6, book.getQuantity());
            pst.setInt(7, book.getPrice());
            pst.setString(8, book.getId());

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

    public List<String> findAllCategories() {
        List<String> categories = new ArrayList<>();

        try {
            Connection connect = DBConnection.getConnection();

            String sql = "SELECT DISTINCT category FROM `book_details` WHERE 1";

            PreparedStatement pst = connect.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                categories.add(rs.getString("category"));
            }

            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }

        return categories;
    }

    public List<Book> findAllByCategory(String bookCategory) {
        List<Book> books = new ArrayList<>();

        try {
            Connection connect = DBConnection.getConnection();
            String sql = "select * from book_details where category = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, bookCategory);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String id = rs.getString("bookID");
                String name = rs.getString("bookName");
                String category = rs.getString("category");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");

                books.add(new Book(id, name, category, author, publisher, quantity, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }
}
