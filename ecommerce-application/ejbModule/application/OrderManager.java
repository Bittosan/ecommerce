package application;


import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Order;
import model.Product;

@Stateless
public class OrderManager implements OrderManagerRemote {

	@PersistenceContext
	private EntityManager em;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addOrder(int id_order, float total, String email ,int id_product, int quantity) {
		
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
