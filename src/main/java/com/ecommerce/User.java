package com.ecommerce;


public class User {
    private int id;
    private String username;
    private String password;

    // Constructors, getters, setters
    public int getId() {
    	return this.id;
    }
    
    public String getUserName() {
    	return this.username;
    }
    
    protected String getPassword() {
    	return this.password;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public void setUserName(String username) {
    	this.username = username;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public boolean changePassword(String newPassword, String oldPassword) {
    	if(oldPassword.equals(this.password)) {
    		setPassword(newPassword);
    		return true;
    	}
    	return false;
    }
}
