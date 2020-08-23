package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.javafaker.Faker;

public class ProductFactory {

	private static Integer productCount = 0;
	
	public static Product getProduct(String name, Money price, Integer quantity, Date expiration, 
			                          String manufactured, String categoryName) {

        return new Product(++productCount, name, price, quantity, expiration , manufactured, categoryName);
    }
	
	 public static Product getFakeProduct() {
		 Faker faker = new Faker();
	        return new Product(
	        		++productCount,
	                faker.commerce().productName(),
	                new Money(faker.currency().code(),(float)faker.number().numberBetween(50, 10000)),
	                faker.number().numberBetween(1, 30),
	                faker.date().birthday(1, 120),
	                faker.country().name(),
	                faker.commerce().department());
	    }
	 
	 public static List<Product> getManyFakeProducts(Integer quantity) {
		 
	        List<Product> products = new ArrayList<>();
	        
	        while (products.size() < quantity){
	            products.add( getFakeProduct());
	        }
	        return products;
	    }
	 private static class SingletonHolder {
	        private final static ProductFactory INSTANCE = new ProductFactory();
	    }

	    public static ProductFactory getInstance() {
	        return SingletonHolder.INSTANCE;
	    }
}
