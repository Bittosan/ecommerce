package model;

import java.io.Serializable;

public class Order implements Serializable{

    private int id_order;
    private float total = 0F;
    private String email;
    private String purchase_data;
    private int id_product;
    private int quantity;
	private static final long serialVersionUID = 1L;
	
	public Order() {
		super();
	}   
	public int getId() {
		return id_order;
	}

	public void setId(int id_order) {
		this.id_order = id_order;
	}   
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getData() {
		return purchase_data;
	}
	public void setData(String purchase_data) {
		this.purchase_data = purchase_data;
	}
	public int getIdProduct() {
		return id_product;
	}
	public void setIdProduct(int id_product) {
		this.id_product = id_product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}