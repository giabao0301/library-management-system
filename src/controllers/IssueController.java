/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.Date;
import models.Book.Book;
import models.Issue.Issue;
import models.Issue.IssueDAO;
import models.Student.Student;
import views.IssueBook;
import views.ReturnBook;

/**
 *
 * @author trinh
 */
public class IssueController {
    private IssueDAO issueDAO;
    private IssueBook issueBook;
    private ReturnBook returnBook;

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
    
    public Issue getByBookIdAndStudentId(String bookId, int studentId) {
        return issueDAO.findByBookIdAndStudentId(bookId, studentId);
    }
    
    public boolean issueBook(Book book, Student student, Date issueDate, Date dueDate) {
        return issueDAO.addIssue(book, student, issueDate, dueDate);
    }
    
    public boolean returnBook(int issueId, String status) {
        return issueDAO.updateById(issueId, status);
    }
}
