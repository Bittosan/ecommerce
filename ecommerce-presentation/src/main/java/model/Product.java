package model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class Product implements Serializable {
	  
	private Integer id_product;
	private String description;
	private String type;
	private double price;
	private int availability;
	private int quantity;
	
	//private String image;
	private String image;

	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}
	
	public Integer getId_product() {
		return id_product;
	}
	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}   
	
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability -= availability;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity += quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	/*
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	} 
	*/ 
}