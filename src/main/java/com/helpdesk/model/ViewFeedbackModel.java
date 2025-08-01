package com.helpdesk.model;

import java.time.LocalDate;

public class ViewFeedbackModel {
    private int feedback_id;
    private int user_id;
    private String email;
    private String problem_title;
    private LocalDate f_date;
    private String comments;

    // Constructor
    public ViewFeedbackModel(int feedback_id, int user_id, String email, String problem_title, LocalDate f_date, String comments) {
        this.feedback_id = feedback_id;
        this.user_id = user_id;
        this.email = email;
        this.problem_title = problem_title;
        this.f_date = f_date;
        this.comments = comments;
    }

    // Getters
    public int getFeedback_id() {
    	return feedback_id; 
    	}
    public int getUser_id() { 
    	return user_id; }
    public String getEmail() { return email; 
    }
    public String getProblem_title() { 
    	return problem_title;
    	}
    public LocalDate getF_date() {
    	return f_date; 
    	}
    public String getComments() {
    	return comments; 
    	}
}
