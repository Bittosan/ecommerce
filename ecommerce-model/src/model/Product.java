package model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Product.findProductByType", query = "SELECT p FROM Product p WHERE p.type=:type"),
    @NamedQuery(name = "Product.findProductById", query = "SELECT p FROM Product p WHERE p.id_product=:id_product")})

public class Product implements Serializable {

	   
	@Id
	private Integer id_product;
	private String description;
	private String type;
	private double price;
	private int availability;
	private String image;
	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}   
	public Integer getId_product() {
		return this.id_product;
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
		return this.availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
   
}
