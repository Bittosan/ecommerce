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
    @NamedQuery(name = "Product.findProductByType", query = "SELECT p FROM Product p WHERE p.tipo=:tipo"),
    @NamedQuery(name = "Product.findProductById", query = "SELECT p FROM Product p WHERE p.id=:idP")})

public class Product implements Serializable {
	   
	@Id
	private Integer id;
	private String descrizione;
	private String tipo;
	private double prezzo;
	private int disponibilita;
	private String immagine;

	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}   
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}   
	public double getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}   
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}  
}