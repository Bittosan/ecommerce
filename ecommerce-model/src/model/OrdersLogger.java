package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class OrdersLogger implements Serializable {

@Id
private int id_order;
private int id_product;
private String email;
private String purchase_data;
private static final long serialVersionUID = 1L;


public OrdersLogger() {
	super();
}   
public int getId() {
	return id_order;
}

public void setId(int id_order) {
	this.id_order = id_order;
}   

public int getId_product() {
	return id_product;
}

public void setId_product(int id_product) {
	this.id_product = id_product;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPurchase_data() {
	return purchase_data;
}

public void setPurchase_data(String purchase_data) {
	this.purchase_data = purchase_data;
}
	
}
