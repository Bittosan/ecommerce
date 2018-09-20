package application;

import java.util.List;
import javax.ejb.Remote;
import model.Product;

@Remote
public interface ProductManagerRemote {

	public List<Product> getProductList(String type);
	public Product findProduct(int id_product);
	public Product upgradeAvailability(int id_product, int availability);
}
