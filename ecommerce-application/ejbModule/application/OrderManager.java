package application;


import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Order;
import model.Product;

@Stateless
public class OrderManager implements OrderManagerRemote {

	@PersistenceContext
	private EntityManager em;

	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Order addOrder(int id_product, String purchase_data, int quantity, float total, String email) {
		try {
			//VEDERE QUESTA QUERY PER INSERIRE IL NUOVO ORDINE
			Order order = (Order) em.createNativeQuery("INSERT INTO Order ('id_product','purchase_data','quantity','total','email') VALUES ('a','b','c','d','e')");
			order.setIdProduct(id_product);
			order.setData(purchase_data);
			order.setQuantity(quantity);
			order.setTotal(total);
			order.setEmail(email);
			em.getTransaction().commit();
			System.out.println("ordine creato con successo");
			
			return order;
		} catch (Exception e) {
			System.err.println("ordine non creato");
			return null;
		}
	}
		

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void modifyQuantity(int id_order, int id_product, int quantity) {
		Order o = em.createNamedQuery("Order.findOrderById", Order.class)
				.setParameter("id_order", id_order).getSingleResult();
		if(o.getIdProduct()==id_product)
		{
			o.setQuantity(quantity);
			em.getTransaction().commit();
		}
	}

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
}

