/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.User;
import models.UserDAO;
import views.HomePage;
import views.LoginForm;
import views.SignupForm;

/**
 *
 * @author trinh
 */
public class UserController {
    private SignupForm signupForm;
    private LoginForm loginForm;
    private UserDAO userDAO;

    public UserController(SignupForm signupForm) {
        this.signupForm = signupForm;
        userDAO = new UserDAO();
    }

    public UserController(LoginForm loginForm) {
        this.loginForm = loginForm;
        userDAO = new UserDAO();
    }
    
    public User getUserByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    public boolean signUp() {
        boolean isSucceeded = false;
        User user = signupForm.getUserInput();

        if (user != null) {
            isSucceeded = userDAO.addUser(user);
        }

        return isSucceeded;
    }

    public boolean login() {
        boolean isSucceeded = false;
        User user = loginForm.getUserInput();
        User DBUser = getUserByUserName(user.getName());

        if (DBUser != null && user.getPassword().equals(DBUser.getPassword())) {
            isSucceeded = true;
        }
        
        return isSucceeded;
    }
}
