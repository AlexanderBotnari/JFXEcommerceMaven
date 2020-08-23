package controllers;

import java.io.File;
import java.io.IOException;

import domain.Product;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import repository.DataRepository;

public class ProductViewController {

	    @FXML
	    private TextField name;

	    @FXML
	    private ImageView image;


	    public void showProduct() throws ClassNotFoundException, IOException {
	    	Product product= DataRepository.getInstance().load(Product.class);
	        name.setText(product.getName());
	        File file = new File("src/main/resources/images/product1.jpg");
	        image.setImage(new Image(file.toURI().toString()));
}
}