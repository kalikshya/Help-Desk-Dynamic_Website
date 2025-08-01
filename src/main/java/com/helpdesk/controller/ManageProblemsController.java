package com.helpdesk.controller;

import com.helpdesk.model.ProblemModel;
import com.helpdesk.service.ProblemService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class ManageProblemsController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/manageProblems" })
public class ManageProblemsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  private ProblemService problemService;
       
	 @Override
	    public void init() throws ServletException {
	        problemService = new ProblemService(); 
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	
           //1. fetch problem list from Db using service
	        List<ProblemModel> problemList = problemService.getAllProblems();
	        
	        //2. set to request
	        request.setAttribute("problems", problemList);
	        
	        //3. forward to jsp
	        request.getRequestDispatcher("/WEB-INF/pages/manageProblems.jsp").forward(request, response);
	    }
	    

	    
	}