package application;

import javax.ejb.Remote;

import model.Product;

@Remote	
public interface OrderManagerRemote {
	
	public void addOrder(int id_order, float total, String email ,int id_product, int quantity);
	public int modifyQuantity(int id_order, int id_product, int quantity);
	public Product findProduct(int id_product);
}