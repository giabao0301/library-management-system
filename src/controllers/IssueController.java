/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.Date;
import java.util.List;
import models.Book.Book;
import models.Book.BookDAO;
import models.Issue.Issue;
import models.Issue.IssueDAO;
import models.Student.Student;
import views.BookPenaltyForm;
import views.HomePage;
import views.IssueBook;
import views.ReturnBook;
import views.ViewAllRecord;

/**
 *
 * @author trinh
 */
public class IssueController {

    private IssueDAO issueDAO;
    private IssueBook issueBook;
    private ReturnBook returnBook;
    private BookPenaltyForm bookPenaltyForm;
    private ViewAllRecord viewAllRecord;
    private HomePage homePage;

    public IssueController(HomePage homePage) {
        this.homePage = homePage;
        issueDAO = new IssueDAO();
    }

    public IssueController(ViewAllRecord viewAllRecord) {
        this.viewAllRecord = viewAllRecord;
        issueDAO = new IssueDAO();
    }

    public IssueController() {
    }

    public IssueController(IssueBook issueBook) {
        this.issueBook = issueBook;
        issueDAO = new IssueDAO();
    }

    public IssueController(ReturnBook returnBook) {
        this.returnBook = returnBook;
        issueDAO = new IssueDAO();
    }

    public IssueController(BookPenaltyForm bookPenaltyForm) {
        this.bookPenaltyForm = bookPenaltyForm;
        issueDAO = new IssueDAO();
    }

    public List<Issue> getAll() {
        return issueDAO.findAll();
    }

    public Issue getByBookIdAndStudentId(String bookId, int studentId) {
        return issueDAO.findByBookIdAndStudentId(bookId, studentId);
    }

    public List<Issue> getViolatedIssueByStudentId(int studentId) {
        return issueDAO.findViolatedIssueByStudentId(studentId);
    }

    public List<Issue> getAllViolatedIssue() {
        return issueDAO.findAllViolatedIssue();
    }

    public boolean issueBook(Book book, Student student, Date issueDate, Date dueDate) {
        return issueDAO.addIssue(book, student, issueDate, dueDate);
    }

    public boolean returnBook(int issueId, String status) {
        return issueDAO.updateById(issueId, status);
    }

    public List<Issue> getByStatus(String status) {
        return issueDAO.findByStatus(status);
    }

    public Issue getViolatedIssueByBookIdAndStudentId(String bookId, int studentId) {
        return issueDAO.findViolatedIssueByBookIdAndStudentId(bookId, studentId);
    }

    public boolean updateById(int id, String status) {
        return issueDAO.updateById(id, status);
    }
    
    public List<Issue> getAllBetweenDates(Date dateFrom, Date dateTo) {
        return issueDAO.findAllBetweenDates(dateFrom, dateTo);
    }
}
