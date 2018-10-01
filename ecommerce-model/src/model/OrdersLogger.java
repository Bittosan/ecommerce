package model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: OrdersLogger
 *
 */
@Entity

@IdClass(OrdersLoggerPK.class)
public class OrdersLogger implements Serializable {

	   
	@Id
	private int id_order;   
	@Id
	private int id_product;
	private String email;
	private String purchase_data;
	private static final long serialVersionUID = 1L;

	public OrdersLogger() {
		super();
	}  
	
	public OrdersLogger(int id_order, int id_product, String purchase_data, String email) {
		super();
		this.id_order = id_order;
		this.id_product = id_product;
		this.purchase_data = purchase_data;
		this.email = email;
	}
	
	public int getId_order() {
		return this.id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}   
	public int getId_product() {
		return this.id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPurchase_data() {
		return this.purchase_data;
	}

	public void setPurchase_data(String purchase_data) {
		this.purchase_data = purchase_data;
	}
   
}
