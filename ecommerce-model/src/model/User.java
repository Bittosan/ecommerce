package model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
<<<<<<< HEAD
 * Entity implementation class for Entity: Users
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.findUser", query = "SELECT u FROM User u WHERE u.email=:email")})

public class User implements Serializable {

	   
	@Id
	private String email;
	private String username;
	private String password;
	private String name;
	private String surname;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	
	public User(String email, String username,String password,String name,String surname) {
		super();
		this.email=email;
		this.username=username;
		this.password=password;
		this.name=name;
		this.surname=surname;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
=======
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.findUser", query = "SELECT u FROM User u WHERE u.email=:email")})

public class User implements Serializable {

	   
	@Id
	private String email;
	private String username;
	private String password;
	private String name;
	private String surname;
	private String numberCreditCard;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}  
	
	public User(String email, String username,String password,String name,String cognome) {
		super();
		this.email=email;
		this.username=username;
		this.password=password;
		this.name=name;
		this.surname=cognome;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}   
	public String getNumberCreditCard() {
		return this.numberCreditCard;
	}

	public void setNumberCreditCard(String numberCreditCard) {
		this.numberCreditCard = numberCreditCard;
>>>>>>> refs/remotes/ecommerce/master
	}
   
}
