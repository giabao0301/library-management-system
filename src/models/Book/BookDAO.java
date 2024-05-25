/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.Book;

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

            String sql = "INSERT INTO book ( id, title, author, genre, publisher, price, quantity)VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, book.getId());
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getAuthor());
            pst.setString(4, book.getGenre());
            pst.setString(5, book.getPublisher());
            pst.setDouble(6, book.getPrice());
            pst.setInt(7, book.getQuantity());

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
            String sql = "select * from book";
            PreparedStatement pst = connect.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                String publisher = rs.getString("publisher");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");

                books.add(new Book(id, title, author, genre, publisher, price, quantity));
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
            String sql = "select * from book where id = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, bookId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String id = rs.getString("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");

                book = new Book(id, title, author, genre, publisher, price, quantity);
            } else {
                book = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    public boolean deleteById(String bookId) {
        try {
            Connection connect = DBConnection.getConnection();

            String sql = "DELETE FROM book WHERE id = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, bookId);

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

            String sql = "UPDATE book SET id = ?, title = ?, author = ?, genre = ?,  publisher = ?, quantity = ?, price = ? WHERE id = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, book.getId());
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getGenre());
            pst.setString(4, book.getAuthor());
            pst.setString(5, book.getPublisher());
            pst.setInt(6, book.getQuantity());
            pst.setDouble(7, book.getPrice());
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

            String sql = "SELECT DISTINCT genre FROM `book` WHERE 1";

            PreparedStatement pst = connect.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                categories.add(rs.getString("genre"));
            }

            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }

        return categories;
    }

    public List<Book> findAllByGenre(String bookGenre) {
        List<Book> books = new ArrayList<>();

        try {
            Connection connect = DBConnection.getConnection();
            String sql = "select * from book where genre = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, bookGenre);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");

                books.add(new Book(id, title, author, genre, publisher, price, quantity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }
}
