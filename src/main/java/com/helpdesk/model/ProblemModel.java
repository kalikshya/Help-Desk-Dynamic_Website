package com.helpdesk.model;

import java.time.LocalDate;

public class ProblemModel {
    private int problem_id;
    private String title;
    private String category;
    private LocalDate date;
    private String status;
    private int dept_id; // foreign key from Department

    
    // Default constructor
    public ProblemModel() {}
    

    // Constructor without ID for adding new problems
    public ProblemModel(String title, String category, LocalDate date, String status, int dept_id) {
        this.title = title;
        this.category = category;
        this.date = date;
        this.status = status;
        this.dept_id = dept_id;
    }

    // Constructor with all fields
    public ProblemModel(int problem_id, String title, String category, LocalDate date, String status, int dept_id) {
        this.problem_id = problem_id;
        this.title = title;
        this.category = category;
        this.date = date;
        this.status = status;
        this.dept_id = dept_id;
    }

    // Getters and Setters
    public int getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(int problem_id) {
        this.problem_id = problem_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
}
