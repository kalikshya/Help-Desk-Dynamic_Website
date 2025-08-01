package com.helpdesk.model;

public class UserProblemModel {
    private int user_id;
    private int problem_id;

    // Default constructor
    public UserProblemModel() {}
    

    // Constructor
    public UserProblemModel(int user_id, int problem_id) {
        this.user_id = user_id;
        this.problem_id = problem_id;
    }

    // Getters and Setters
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


