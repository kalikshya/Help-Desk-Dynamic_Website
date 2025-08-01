package com.helpdesk.model;

	
public class UserModel{
	private int user_id;
	private String full_name;
    private String username;
    private String contact;
    private String email;
    private String password;
    private String address;
    private String status;
    private String role;
	

	//Default Constructor

   
    public UserModel() {
        
    }
    

    //Constructor for Login
    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
    

 //  Constructor for Registration (Full Name, Email, Password)
    public UserModel(String full_name, String email, String password) {
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.status = "active";  // Default status
        this.role = "user";      // Default role
    }
    
    
 // Constructor with all fields
    public UserModel(int user_id, String full_name, String username, String email, String password,
                     String contact, String address, String status, String role) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.username = username;
        this.contact = contact;
        this.email = email;
        this.password = password;   
        this.address = address;
        this.status = status;
        this.role = role;
    }
    
    
    // Getters and Setters
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
    
    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
     
    
    }
