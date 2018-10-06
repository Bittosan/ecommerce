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
	
<<<<<<< HEAD
	@PersistenceContext(unitName="ecommerce-model")
=======
	@PersistenceContext
>>>>>>> refs/remotes/ecommerce/master
	private EntityManager em;
 
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Product> getProductList(String type) {
		// TODO Auto-generated method stub
		try{
			List<Product> list = em.createNamedQuery("Product.findProductByType", Product.class)
					.setParameter("type", type).getResultList();
			return list;
		}catch(Exception e){
			System.err.println("Errore nel caricamento della lista del tipo di prodotto");
			return null;
		}
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Product upgradeAvailability(int id_product, int availability) {
		// TODO Auto-generated method stub
		try {
			Product p=em.createNamedQuery("Product.findProductById", Product.class)
					.setParameter("id_product", id_product).getSingleResult();
			p.setAvailability(availability);
			em.getTransaction().commit();
			return p;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Product findProduct(Integer id_product) {
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
