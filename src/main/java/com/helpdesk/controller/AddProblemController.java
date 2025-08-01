package com.helpdesk.controller;

import com.helpdesk.model.ProblemModel;
import com.helpdesk.service.ProblemService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Servlet implementation class AddProblemController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/addProblem" })
public class AddProblemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProblemService problemService;
    
	@Override
    public void init() throws ServletException {
        problemService = new ProblemService();
    }

	

	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Show addProblem.jsp page
	        request.getRequestDispatcher("/WEB-INF/pages/addProblem.jsp").forward(request, response);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        try {
	            // 1. Get form values
	            String title = request.getParameter("title");
	            String dateStr = request.getParameter("dateReported");
	            String status = request.getParameter("status");
	            String category = request.getParameter("category");
	            LocalDate date = LocalDate.parse(dateStr); // May throw exception

	            // 2. Create ProblemModel
	            ProblemModel problem = new ProblemModel();
	            problem.setTitle(title);
	            problem.setCategory(category);
	            problem.setDate(date);
	            problem.setStatus(status);
	            problem.setDept_id(1); // Default department ID for now

	            // 3. Insert via service
	            boolean success = problemService.addProblem(problem);

	            // 4. Redirect or show error
	            if (success) {
	                response.sendRedirect(request.getContextPath() + "/manageProblems");
	            } else {
	                request.setAttribute("error", "Failed to add problem. Please try again.");
	                request.getRequestDispatcher("/WEB-INF/pages/addProblem.jsp").forward(request, response);
	            }

	        } catch (Exception e) {
	            request.setAttribute("error", "Invalid input or date format.");
	            request.getRequestDispatcher("/WEB-INF/pages/addProblem.jsp").forward(request, response);
	        }
	    }
	    
	    }

