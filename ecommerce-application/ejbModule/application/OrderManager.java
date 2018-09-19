package application;

import java.util.List;

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
	public void addOrder(int idOrder, float total, String idUser, String userEmail, int idProduct, int quantity) {

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public int modifyQuantity(int idOrder, int idProduct, int quantity) {
		Order o = em.createNamedQuery("Order.findOrderById", Order.class)
				.setParameter("idOrder", idOrder).getSingleResult();
		if(o.getIdProduct()==idProduct)
		{
			o.setQuantity(quantity);
			em.getTransaction().commit();
		}
		
		return quantity;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Product findProduct(int idp) {
		// TODO Auto-generated method stub
		try {
			Product p=em.createNamedQuery("Product.findProductById", Product.class)
					.setParameter("idP", idp).getSingleResult();
			return p;
		} catch (Exception e) {
			return null;
		}
	}

	
	
}
