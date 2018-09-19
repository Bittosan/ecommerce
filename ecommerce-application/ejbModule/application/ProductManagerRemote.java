package application;

import java.util.List;

import javax.ejb.Remote;

import model.Product;

@Remote
public interface ProductManagerRemote {

	public List<Product> getProductList(String productType);
	public Product findProduct(int idProdotto);
	public Product upgradeAvailability(int idProdotto, int availability);
}
