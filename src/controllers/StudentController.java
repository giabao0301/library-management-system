/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.List;
import models.Student.Student;
import models.Student.StudentDAO;
import views.HomePage;
import views.IssueBook;
import views.ManageStudents;
import views.ReturnBook;

/**
 *
 * @author trinh
 */
public class StudentController {

    private ManageStudents manageStudents;
    private StudentDAO studentDAO;
    private IssueBook issueBook;
    private ReturnBook returnBook;
    private HomePage homePage;

    public StudentController(HomePage homePage) {
        this.homePage = homePage;
        studentDAO = new StudentDAO();
    }

    public StudentController(ManageStudents manageStudents) {
        this.manageStudents = manageStudents;
        studentDAO = new StudentDAO();
    }

    public StudentController(IssueBook issueBook) {
        this.issueBook = issueBook;
        studentDAO = new StudentDAO();
    }

    public StudentController(ReturnBook returnBook) {
        this.returnBook = returnBook;
        studentDAO = new StudentDAO();
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAllStudents();
    }

    public boolean addNewStudent(Student student) {
        boolean isAdded = false;

        if (studentDAO.addStudent(student)) {
            isAdded = true;
        }

        return isAdded;
    }

    public boolean deleteStudent(int studentId) {
        if (studentDAO.deleteById(studentId)) {
            return true;
        }
        return false;
    }

    public boolean updateStudent(Student student) {
        if (studentDAO.updateStudent(student)) {
            return true;
        }
        return false;
    }

    public Student getStudentById(int studentId) {
        return studentDAO.findById(studentId);
    }

    public List<String> getAllMajors() {
        return studentDAO.findAllMajors();
    }

    public List<Student> getAllByMajor(String major) {
        return studentDAO.findAllByMajor(major);
    }
}
