package com.helpdesk.controller;

import com.helpdesk.model.UserModel;
import com.helpdesk.service.UserManagementService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class UserManagementController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/userManagement" })
public class UserManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private UserManagementService userService;

	    @Override
	    public void init() throws ServletException {
	        userService = new UserManagementService();
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String keyword = request.getParameter("keyword");
	        List<UserModel> users;

	        if (keyword != null && !keyword.trim().isEmpty()) {
	            users = userService.searchUsers(keyword.trim());
	        } else {
	            users = userService.getAllUsers();
	        }

	        request.setAttribute("userList", users);
	        request.setAttribute("keyword", keyword);
	        request.getRequestDispatcher("/WEB-INF/pages/userManagement.jsp").forward(request, response);  
	    }
       
}