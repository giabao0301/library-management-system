/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.List;
import models.Student;
import models.StudentDAO;
import views.ManageStudents;

/**
 *
 * @author trinh
 */
public class StudentController {

    private ManageStudents manageStudents;
    private StudentDAO studentDAO;

    public StudentController(ManageStudents manageStudents) {
        this.manageStudents = manageStudents;
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

    public boolean deleteStudent(String studentId) {
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
    
    public Student getStudentById(String studentId) {
        return studentDAO.findById(studentId);
    }
    
    public List<String >getAllMajors() {
        return studentDAO.findAllMajors();
    }
    
    public List<Student> getAllByMajor(String major) {
        return studentDAO.findAllByMajor(major);
    }
}
