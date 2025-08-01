package com.helpdesk.controller;

import com.helpdesk.model.UserModel;
import com.helpdesk.service.AdminProfileService;
import com.helpdesk.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class AdminProfileController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/adminProfile" })
public class AdminProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private AdminProfileService adminProfileService;
   
   @Override
   public void init() {
       adminProfileService = new AdminProfileService();
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
       UserModel admin = (UserModel) SessionUtil.getAttribute(req, "user");
       req.setAttribute("admin", admin);
       req.getRequestDispatcher("/WEB-INF/pages/adminProfile.jsp").forward(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
       String full_name = req.getParameter("full_name");
       String email = req.getParameter("email");
       String username = req.getParameter("username");
       String password = req.getParameter("password");

       UserModel currentAdmin = (UserModel) SessionUtil.getAttribute(req, "user");

       UserModel updated = new UserModel();
       updated.setUser_id(currentAdmin.getUser_id());
       updated.setFull_name(full_name);
       updated.setEmail(email);
       updated.setUsername(username);
       updated.setPassword(password); // hash the password 

       boolean success = adminProfileService.updateAdminProfile(updated);

       if (success) {
           req.setAttribute("message", "Profile updated successfully.");
           // Update session too if needed
           SessionUtil.setAttribute(req, "user", updated);
       } else {
           req.setAttribute("error", "Failed to update profile.");
       }

       req.getRequestDispatcher("/WEB-INF/pages/adminProfile.jsp").forward(req, resp);
   }
}
