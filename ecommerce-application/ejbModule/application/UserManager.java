package application;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import model.User;

@Stateless
public class UserManager implements UserManagerRemote {

	@PersistenceContext
	EntityManager em;
	
	public UserManager(){}

	@Override
	public boolean controlPassword(String password, String confPassword) {
		// TODO Auto-generated method stub
		if(password.equals(confPassword))
			return true;
		else
			return false;
	}
	
	//Verifica presenza utente nel db
	@Override
	public boolean checkUser(String email) {
		// TODO Auto-generated method stub
		try{
			User user = em.createNamedQuery("User.findUser", User.class).setParameter("email", email).getSingleResult();
			return true;
		}catch(NoResultException e){
			System.err.println("utente non trovato");
			return false;
		}	
	}

	/*se l'utente esiste te lo restituisce pure e ti fa accedere*/
	@Override
	public User loginControl(String email, String password) {
		User user = em.find(User.class, email);
		if(user!=null && user.getPassword().equals(password))
			return user;
		else
			return null;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public User getUser(String email) {
		try{
			User user =em.createNamedQuery("User.findUser", User.class).setParameter("email",email).getSingleResult();
			return user;
		}catch(NoResultException e){
			System.err.println("utente non trovato");
			return null;
		}	
	}
	
	@Override
	public void updateUser(User user) {
		try{
			User u = em.find(User.class, user.getEmail());
			u.setPassword(user.getPassword());
		} catch(Exception e){
			System.err.println("Errore nella modifica dei dati dell'utente");
	    }
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void saveUser(String email, String username, String password, String nome, String cognome) {
		try {
			em.persist(new User(email,username,password,nome,cognome));
			System.out.println("utente creato con successo");
		} catch (Exception e) {
			System.err.println("utente non creato");
		}
	}

}
