package application;

<<<<<<< HEAD
import java.util.ArrayList;

import javax.ejb.Remote;

import model.OrdersLogger;
import model.Product;

@Remote	
public interface OrderManagerRemote {
	
	public void modifyQuantity(int id_order, int id_product, int quantity);
	public Product findProduct(int id_product);
//	public void addOrdersLogger(int id_order, int id_product, String purchase_data, String email);
	public void addOrderDB(int id_order, float total, String purchase_data, int id_product, int quantity, String email);
	public int getLastIdOrder();
	public ArrayList<OrdersLogger> getAllOrderLogger();
	public void addOrdersLoggerQueue(int id_order, int id_product, String purchase_data, String email);
=======
import javax.ejb.Remote;

import model.OrdersLogger;
import model.Product;

@Remote	
public interface OrderManagerRemote {
	
	public void modifyQuantity(int id_order, int id_product, int quantity);
	public Product findProduct(int id_product);
	public void addOrdersLogger(int id_order, int id_product, String purchase_data, String email);
	public void addOrderDB(int id_order, float total, String purchase_data, int id_product, int quantity, String email);
	public int getLastIdOrder();
>>>>>>> refs/remotes/ecommerce/master

}