package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (DaoFactory.getUsersDao().findByUsername(username) != null) {
            try {
                response.sendRedirect(request.getContextPath() + "/register?error=username");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // TODO: Perform data validation, check if the username and email are unique, etc.

        System.out.println("Received form data:");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        User newUser = new User(username, email, password);

        User createdUser = DaoFactory.getUsersDao().createUser(newUser);
        if (createdUser != null) {
            try {
                System.out.println("User creation successful. User object: " + createdUser);
                response.sendRedirect(request.getContextPath() + "/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("User creation failed. User object: " + newUser);
            try {
                response.sendRedirect(request.getContextPath() + "/register?error=1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
