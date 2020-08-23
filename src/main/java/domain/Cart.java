package domain;

import java.util.ArrayList;
import java.util.List;

public class Cart implements ProductRepository{
     
	private static List<Product> products = new ArrayList<>();
	
	private Money total;

	@Override
	public void add(Product fakeProducts) {
		if(fakeProducts != null)
		products.add(fakeProducts);
	}

	@Override
	public void delete(Integer productId) {
		 Product product = findById(productId);
                if (product != null) 
	            products.remove(product);
	        
	}

	@Override
	public void updateQuantity(Integer productId, Integer newQuantity) {
	     Product product = findById(productId);
	     product.setQuantity(newQuantity);
	}

	@Override
	public Product findById(Integer productId) {
		for (Product p : products) {
			if(p.getId().equals(productId)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<Product> findAll() {
		return products;
	}

	@Override
	public List<Product> findByName(String productName) {
		List<Product> results = new ArrayList<>();
		for (Product p : products) {
			if(p.getName().equals(productName)) 
			   results.add(p);
		}	
	    return results;
	}
	@Override
	public List<Product> findByManufacturer(String productManufacturer) {
		List<Product> results = new ArrayList<>();
		for (Product p : products) {
			if(p.getManufactured().equals(productManufacturer)) 
			   results.add(p);
		}	
	    return results;
	}

	public List<Product> findByCategory(String category) {
		List<Product> results = new ArrayList<>();
		for (Product p : products) {
			if(p.getCategory().getName().equals(category)) 
			   results.add(p);
		}	
	    return results;
	}
	//////////Bussines Logic////////////////
	public void calculateTotal() {
		Float total = 0f;
		for (Product p : products) {
			total += p.getPrice().getAmount() * p.getQuantity();
		}
		this.total = new Money(total);
	}

	public Money getTotal() {
		return total;
	}
	//////////////Singleton/////////////////
	private static class SingletonHolder {
        private final static Cart INSTANCE = new Cart();
    }

    public static Cart getInstance() {
        return SingletonHolder.INSTANCE;
    }
	
}
