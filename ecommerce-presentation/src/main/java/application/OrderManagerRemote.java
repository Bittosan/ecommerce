package application;

import javax.ejb.Remote;

import model.Order;
import model.Product;

@Remote	
public interface OrderManagerRemote {
	
	public Order addOrder(int id_product, String purchase_data, int quantity, float total, String email);
	public void modifyQuantity(int id_order, int id_product, int quantity);
	public Product findProduct(int id_product);
}