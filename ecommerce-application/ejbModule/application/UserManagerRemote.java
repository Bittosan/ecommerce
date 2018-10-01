package application;

import javax.ejb.Remote;

import model.User;

@Remote
public interface UserManagerRemote {

	public void saveUser(String email,String username,String password,String name,String surname);
	public boolean controlPassword(String password, String repeatPassword);
	public boolean checkUser(String username);
	public User loginControl(String username, String password);
	public User getUser(String username);
	public void updateUser(User user);
}
 