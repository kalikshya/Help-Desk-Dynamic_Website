package com.helpdesk.controller;

import com.helpdesk.model.UserModel;
import com.helpdesk.service.LoginService;
import com.helpdesk.util.CookieUtil;
import com.helpdesk.util.PasswordUtil;
import com.helpdesk.util.SessionUtil;
import com.helpdesk.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// ✅ Basic Validation
		if (ValidationUtil.isNullOrEmpty(email) || ValidationUtil.isNullOrEmpty(password)) {
			request.setAttribute("error", "Email and Password are required.");
			request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
			return;
		}

		if (!ValidationUtil.isValidEmail(email)) {
			request.setAttribute("error", "Invalid email format.");
			request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
			return;
		}

		LoginService service = new LoginService();
		UserModel user = service.login(email, password);

		if (user != null) {
			SessionUtil.setAttribute(request, "user", user);
			CookieUtil.addCookie(response, "user_email", user.getEmail(), 60 * 60 * 24); // 1 day

			// ✅ Role check by email (static admin)
			if ("kcjohn@gmail.com".equalsIgnoreCase(user.getEmail())) {
				response.sendRedirect(request.getContextPath() + "/adminDashboard");
			} else {
				response.sendRedirect(request.getContextPath() + "/userDashboard");
			}
		} else {
			request.setAttribute("error", "Invalid email or password.");
			request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
		}
	}
}
