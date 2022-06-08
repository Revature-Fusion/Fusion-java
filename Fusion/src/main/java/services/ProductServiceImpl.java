package services;

import exceptions.ResourceNotFoundException;
import models.Product;
import repositories.ProductRepo;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepo pr;

    public ProductServiceImpl(ProductRepo pr) {
        this.pr = pr;
    }

    @Override
    public Product getProduct(int id) throws ResourceNotFoundException {
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
    public Product updateProduct(Product change) throws ResourceNotFoundException {
        return pr.updateProduct(change);
    }

    @Override
    public Product deleteProduct(int id) throws ResourceNotFoundException {
        return pr.deleteProduct(id);
    }
}
