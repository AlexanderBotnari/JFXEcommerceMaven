package domain;

import java.util.List;

public interface ProductRepository {
    
	public void add(Product product);
	public void delete(Integer productId);
	public void updateQuantity(Integer productId, Integer newQuantity);
	
	public Product findById(Integer productId);
	public List<Product> findAll();
	public List<Product> findByName(String productName);
	public List<Product> findByManufacturer(String productManufacturer);
	public List<Product> findByCategory(String category);
}