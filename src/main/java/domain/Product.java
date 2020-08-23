package domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Product implements Serializable{
    
	private Integer  id;
	private String   name;
	private Money    price;
	private Integer  quantity;
	private Date     expiration;
	private String   manufactured;
	private Category category;
	
	protected Product(Integer id, String name, Money price, Integer quantity, Date expiration, String manufactured,
			String categoryName) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.expiration = expiration;
		this.manufactured = manufactured;
		this.category = new Category(categoryName);;
	}
    public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Money getPrice() {
		return price;
	}



	public void setPrice(Money price) {
		this.price = price ;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Date getExpiration() {
		return expiration;
	}



	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}



	public String getManufactured() {
		return manufactured;
	}



	public void setManufactured(String manufactured) {
		this.manufactured = manufactured;
	}



	public Category getCategory() {
		return this.category;
	}



	public void setCategory(String categoryName) {
		this.category = new Category(categoryName);
	}



	@Override
	public String toString() {
		return "Product ID : "+ id +"\nName : " + name + "\nPrice : " + price + "\nQuantity : " + quantity + "\nExpiration : " + expiration
				+ "\nManufactured : " + manufactured + "\nCategory : " + category;
	}
	
}
