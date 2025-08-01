package com.helpdesk.model;

import java.time.LocalDate;

public class FeedbackModel {
    private int feedback_id;
    private LocalDate f_date;
    private String comments;
    private int user_id;     // foreign key from user
    private int problem_id;  // foreign key from problem

    
    // Default constructor
    public FeedbackModel() {}

    
    // Constructor without ID
    public FeedbackModel(LocalDate f_date, String comments, int user_id, int problem_id) {
        this.f_date = f_date;
        this.comments = comments;
        this.user_id = user_id;
        this.problem_id = problem_id;
    }

    // Full constructor
    public FeedbackModel(int feedback_id, LocalDate f_date, String comments, int user_id, int problem_id) {
        this.feedback_id = feedback_id;
        this.f_date = f_date;
        this.comments = comments;
        this.user_id = user_id;
        this.problem_id = problem_id;
    }

    // Getters and Setters
    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    
    
    public LocalDate getF_date() {
        return f_date;
    }

    public void setF_date(LocalDate f_date) {
        this.f_date = f_date;
    }

    
    
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    
    
    public int getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(int problem_id) {
        this.problem_id = problem_id;
    }
}
