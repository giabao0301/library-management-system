/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.List;
import models.Book.BookDAO;
import models.Penalty.Penalty;
import models.Penalty.PenaltyDAO;
import views.BookPenaltyForm;
import views.HomePage;

/**
 *
 * @author trinh
 */
public class PenaltyController {

    private BookPenaltyForm bookPenaltyForm;
    private PenaltyDAO penaltyDAO;
    private HomePage homePage;
    
    public PenaltyController(HomePage homePage) {
        this.homePage = homePage;
        penaltyDAO = new PenaltyDAO();
    }
    public PenaltyController(BookPenaltyForm bookPenaltyForm) {
        this.bookPenaltyForm = bookPenaltyForm;
        penaltyDAO = new PenaltyDAO();
    }
    
    public PenaltyController() {
    }
    
    public boolean addPenalty(Penalty penalty) {
        return penaltyDAO.addPenalty(penalty);
    }
    
    public List<Penalty> getAllPenalties() {
        return penaltyDAO.findAll();
    }
    
    public Penalty getByStudentIdAndBookId(String bookId, int studentId) {
        return penaltyDAO.findByStudentIdAndBookId(bookId, studentId);
    }
    
}
