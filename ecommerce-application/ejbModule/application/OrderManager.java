package application;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Orders;
import model.OrdersLogger;
import model.Product;

@Stateless
public class OrderManager implements OrderManagerRemote {

	@PersistenceContext
	private EntityManager em;

	//Metodo utilizzato per salvare l'ordine nella tabella Orders del database

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addOrderDB(int id_order, float total, String purchase_data, int id_product, int quantity, String email) {
		
		try {
			em.persist(new Orders(id_order, total, purchase_data, id_product, quantity, email));
			System.out.println("Ordine creato");
		} catch(Exception e)
		{
			System.err.println("Ordine non creato");
		}
	
	}
	
	//Meetodo utilizzato per salvare i dati nella tabella Orders Logger del database
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addOrdersLogger(int id_order, int id_product, String purchase_data, String email) {

		try {
			em.persist(new OrdersLogger(id_order, id_product, purchase_data, email));
			System.out.println("Log Ordini salvato");
		} catch(Exception e)
		{
			System.err.println("Log Ordini non creato");
		}
		
	}
		
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void modifyQuantity(int id_order, int id_product, int quantity) {
		Orders o = em.createNamedQuery("Orders.findOrderById", Orders.class)
				.setParameter("id_order", id_order).getSingleResult();
		if(o.getId_product()==id_product)
		{
			o.setQuantity(quantity);
			em.getTransaction().commit();
		}
	}

	//Metodo utilizzato per poter cercare un prodotto nella tabella Product del database
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Product findProduct(int id_product) {
		// TODO Auto-generated method stub
		try {
			Product p=em.createNamedQuery("Product.findProductById", Product.class)
					.setParameter("id_product", id_product).getSingleResult();
			return p;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public int getLastIdOrder() {
		
		return (int) em.createQuery("SELECT MAX(o.id_order) FROM Orders o").getSingleResult();
	}
	
}
