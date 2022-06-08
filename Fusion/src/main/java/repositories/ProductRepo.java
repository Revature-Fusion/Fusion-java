package repositories;

import exceptions.ResourceNotFoundException;
import models.Product;

import java.util.List;

public interface ProductRepo {

    Product getProduct(int id) throws ResourceNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct(Product change) throws ResourceNotFoundException;

    Product deleteProduct(int id) throws ResourceNotFoundException;
}
