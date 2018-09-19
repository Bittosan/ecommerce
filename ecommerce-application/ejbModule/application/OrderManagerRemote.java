package application;

import javax.ejb.Remote;

import model.Product;

@Remote	
public interface OrderManagerRemote {
	
	public void addOrder(int idOrder, float total, String idUser, String userEmail ,int idProduct, int quantity);
	public int modifyQuantity(int idOrder, int idProduct, int quantity);
	public Product findProduct(int idProduct);
}