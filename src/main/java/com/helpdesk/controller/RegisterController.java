package com.helpdesk.controller;

import com.helpdesk.model.UserModel;
import com.helpdesk.service.RegisterService;
import com.helpdesk.util.PasswordUtil;
import com.helpdesk.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Retrieve form values
        String full_name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        RegisterService service = new RegisterService();

        // 2. Validate Full Name
        if (!ValidationUtil.isValidFullName(full_name)) {
            request.setAttribute("error", "Invalid name. Only letters and spaces allowed.");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            return;
        }

        // 3. Validate Email
        if (!ValidationUtil.isValidEmail(email)) {
            request.setAttribute("error", "Invalid email format.");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            return;
        }

        // 4. Email already exists?
        if (service.emailExists(email)) {
            request.setAttribute("error", "Email already registered.");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            return;
        }

        // 5. Validate Password Strength
        if (!ValidationUtil.isValidPassword(password)) {
            request.setAttribute("error", "Password must contain at least 8 characters, 1 uppercase, 1 number, and 1 special character.");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            return;
        }

        // 6. Confirm Password Match
        if (!ValidationUtil.doPasswordsMatch(password, confirmPassword)) {
            request.setAttribute("error", "Passwords do not match.");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            return;
        }

        // 7. Hash password and create user
        String hashedPassword = PasswordUtil.hashPassword(password);
        UserModel user = new UserModel(full_name, email, hashedPassword);

        // 8. Register user and redirect
        boolean isRegistered = service.registerUser(user);
        if (isRegistered) {
            request.getSession().setAttribute("success", "Registration successful! Please login.");
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.setAttribute("error", "Registration failed. Try again.");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        }
    }
}
