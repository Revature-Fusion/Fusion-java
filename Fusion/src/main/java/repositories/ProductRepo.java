package repositories;

import models.Product;

import java.util.List;

public interface ProductRepo {

    Product getProduct(int id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct(Product change);

    Product deleteProduct(int id);
}
