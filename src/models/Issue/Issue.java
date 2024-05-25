/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.Issue;

import java.time.LocalDate;

/**
 *
 * @author trinh
 */
public class Issue {
    private int id;
    private String bookId;
    private String bookName;
    private int studentId;
    private String studentName;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private String status;

    public Issue(int id, String bookName, String studentName) {
        this.id = id;
        this.bookName = bookName;
        this.studentName = studentName;
    }

    
    
    public Issue(int id, String bookId, String bookName, int studentId, String studentName, LocalDate issueDate, LocalDate dueDate, String status) {
        this.id = id;
        this.bookId = bookId;
        this.bookName = bookName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
