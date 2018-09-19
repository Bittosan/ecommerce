package application;

import javax.ejb.Remote;

import model.User;

@Remote
public interface UserManagerRemote {

	public void saveUser(String email,String username,String password,String nome,String cognome);
	public boolean controlPassword(String password, String confPassword);
	public boolean checkUser(String username);
	public User loginControl(String username, String password);
	public User getUser(String username);
	public void updateUser(User user);
}