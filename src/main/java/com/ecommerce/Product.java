package com.ecommerce;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
	private int id;
    private String name;
    private double price;
    private String imageUrl;
    private boolean buyLater = false;
    
    public void setId(int id) {
    	this.id = id;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public void setPrice(double price) {
    	this.price = price;
    }
    
    public int getId() {
    	return this.id;
    }
    public String getName() {
    	return this.name;
    }
    public double getPrice() {
    	return this.price;
    }
    
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + '}';
    }

    // Method to provide a custom representation
    public String getProductInfo() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + '}';
    }
    
 // Getter and setter for imageUrl
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public boolean isBuyLater() {
        return buyLater;
    }

    public void setBuyLater(boolean buyLater) {
        this.buyLater = buyLater;
    }

    // Constructors, getters, and setters (generated or manually implemented)
}
