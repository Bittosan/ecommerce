package model;

import java.io.Serializable;
import java.lang.String;

public class Orders implements Serializable {


	private int id_order;
	private float total;
	private String purchase_data;   
	private int id_product;
	private int quantity;
	private String email;
	private static final long serialVersionUID = 1L;

	public Orders() {
		super();
	}   
	
	public Orders(int id_order, float total, String purchase_data, int id_product, int quantity, String email) {
		super();
		this.id_order = id_order;
		this.id_product = id_product;
		this.purchase_data = purchase_data;
		this.quantity = quantity;
		this.total = total;
		this.email = email;
	}
	
	public int getId_order() {
		return this.id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}   
	public float getTotal() {
		return this.total;
	}

	public void setTotal(float total) {
		this.total = total;
	}   
	public String getPurchase_data() {
		return this.purchase_data;
	}

	public void setPurchase_data(String purchase_data) {
		this.purchase_data = purchase_data;
	}   
	public int getId_product() {
		return this.id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}   
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
}
