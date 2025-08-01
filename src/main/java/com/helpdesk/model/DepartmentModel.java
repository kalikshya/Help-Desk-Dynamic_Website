package com.helpdesk.model;

public class DepartmentModel {
    private int dept_id;
    private String dept_name;
    private String dept_email;
    private String dept_address;
    private String dept_hours;

    // Default constructor
    public DepartmentModel() {}

    // Constructor without ID
    public DepartmentModel(String dept_name, String dept_email, String dept_address, String dept_hours) {
        this.dept_name = dept_name;
        this.dept_email = dept_email;
        this.dept_address = dept_address;
        this.dept_hours = dept_hours;
    }

    // Full constructor
    public DepartmentModel(int dept_id, String dept_name, String dept_email, String dept_address, String dept_hours) {
        this.dept_id = dept_id;
        this.dept_name = dept_name;
        this.dept_email = dept_email;
        this.dept_address = dept_address;
        this.dept_hours = dept_hours;
    }

    // Getters and Setters
    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_email() {
        return dept_email;
    }

    public void setDept_email(String dept_email) {
        this.dept_email = dept_email;
    }

    public String getDept_address() {
        return dept_address;
    }

    public void setDept_address(String dept_address) {
        this.dept_address = dept_address;
    }

    public String getDept_hours() {
        return dept_hours;
    }

    public void setDept_hours(String dept_hours) {
        this.dept_hours = dept_hours;
    }
}
