package controllers;

import java.util.List;
import models.Book.Book;
import models.Book.BookDAO;
import views.BookPenaltyForm;
import views.HomePage;
import views.IssueBook;
import views.ManageBooks;
import views.ReturnBook;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author trinh
 */
public class BookController {

    private ManageBooks manageBooks;
    private IssueBook issueBook;
    private ReturnBook returnBook;
    private BookDAO bookDAO;
    private BookPenaltyForm bookPenaltyForm;
    private HomePage homePage;
    
    public BookController(HomePage homePage) {
        this.homePage = homePage;
        bookDAO = new BookDAO();
    }
    
    public BookController(ManageBooks manageBooks) {
        this.manageBooks = manageBooks;
        bookDAO = new BookDAO();
    }
    
    public BookController(IssueBook issueBook) {
        this.issueBook = issueBook;
        bookDAO = new BookDAO();
    }

    public BookController(ReturnBook returnBook) {
        this.returnBook = returnBook;
        bookDAO = new BookDAO();
    }
    
    public BookController(BookPenaltyForm bookPenaltyForm) {
        this.bookPenaltyForm = bookPenaltyForm;
        bookDAO = new BookDAO();
    }
    
    public List<Book> getAllBooks() {
        return bookDAO.findAllBooks();
    }

    public boolean addNewBook(Book book) {
        boolean isAdded = false;

        if (bookDAO.addBook(book)) {
            isAdded = true;
        }

        return isAdded;
    }

    public boolean deleteBook(String bookId) {
        if (bookDAO.deleteById(bookId)) {
            return true;
        }
        return false;
    }

    public boolean updateBook(Book book) {
        if (bookDAO.updateBook(book)) {
            return true;
        }
        return false;
    }
    
    
    public Book getBookById(String bookId) {
       return bookDAO.findById(bookId);
    }
    
    public List<String> getAllCategories() {
        return bookDAO.findAllCategories();
    }
    
    public List<Book> getAllByCategory(String genre) {
        return bookDAO.findAllByGenre(genre);
    }
}
