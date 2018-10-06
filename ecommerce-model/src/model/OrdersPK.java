package model;

import java.io.Serializable;

/**
 * ID class for entity: Orders
 *
 */ 
public class OrdersPK  implements Serializable {   
   
	         
	private int id_order;         
	private int id_product;
	private static final long serialVersionUID = 1L;

	public OrdersPK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof OrdersPK)) {
			return false;
		}
		OrdersPK other = (OrdersPK) o;
		return true
			&& getId_order() == other.getId_order()
			&& getId_product() == other.getId_product();
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getId_order();
		result = prime * result + getId_product();
		return result;
	}
   
   
}
