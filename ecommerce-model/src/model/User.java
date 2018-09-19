package model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
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
	private String nome;
	private String cognome;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}
	
	public User(String email, String username,String password,String nome,String cognome) {
		super();
		this.email=email;
		this.username=username;
		this.password=password;
		this.nome=nome;
		this.cognome=cognome;
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
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
  
}