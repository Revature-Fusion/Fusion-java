package services;

import models.Product;
import repositories.ProductRepo;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepo pr;

    public ProductServiceImpl(ProductRepo pr) {
        this.pr = pr;
    }

    @Override
    public Product getProduct(int id) {
        return pr.getProduct(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return pr.getAllProducts();
    }

    @Override
    public Product createProduct(Product product) {
        return pr.createProduct(product);
    }

    @Override
    public Product updateProduct(Product change) {
        return pr.updateProduct(change);
    }

    @Override
    public Product deleteProduct(int id) {
        return pr.deleteProduct(id);
    }
}
