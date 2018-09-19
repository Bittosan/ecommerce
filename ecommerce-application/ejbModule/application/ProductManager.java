package application;

import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Product;

@Stateless
public class ProductManager implements ProductManagerRemote {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Product> getProductList(String type) {
		// TODO Auto-generated method stub
		try{
			List<Product> list = em.createNamedQuery("Product.findProductByType", Product.class)
					.setParameter("tipo", type).getResultList();
			return list;
		}catch(Exception e){
			System.err.println("Errore nel caricamento della lista del tipo di prodotto");
			return null;
		}
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
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Product upgradeAvailability(int idp, int availability) {
		// TODO Auto-generated method stub
		try {
			Product p=em.createNamedQuery("Product.findProductById", Product.class)
					.setParameter("idP", idp).getSingleResult();
			p.setDisponibilita(availability);
			em.getTransaction().commit();
			return p;
		} catch (Exception e) {
			return null;
		}
	}
}
