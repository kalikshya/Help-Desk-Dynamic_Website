package com.helpdesk.controller;

import com.helpdesk.service.ViewFeedbackService;
import com.helpdesk.model.ViewFeedbackModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ViewFeedbackController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/viewFeedback" })
public class ViewFeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
private ViewFeedbackService feedbackService;

@Override
public void init() throws ServletException {
    feedbackService = new ViewFeedbackService();
}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    List<ViewFeedbackModel> feedbacks = feedbackService.getAllFeedbacks();
    request.setAttribute("feedbackList", feedbacks);

    request.getRequestDispatcher("/WEB-INF/pages/viewFeedback.jsp").forward(request, response);
}
}
