package repositories;

import exceptions.ResourceNotFoundException;
import models.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;

public class ProductRepoTest {

    static ProductRepo pr = new ProductRepoImpl();

    static Product product;

    static Product createdProduct;

    public ProductRepoTest() {}

    @Before
    public void setUp() {
        Product p = new Product(1, "name", "desc", 12f, 15, null);
        product = pr.createProduct(p);
    }

    @After
    public void tearDown() {
        try {
            if (product != null) {
                pr.deleteProduct(product.getP_id());
                product = null;
            }
            if (createdProduct != null) {
                pr.deleteProduct(createdProduct.getP_id());
                createdProduct = null;
            }
        } catch(ResourceNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void createProduct() {
        Product expected = new Product(1, "name", "desc", 12f, 15, null);
        createdProduct = pr.createProduct(expected);
        expected.setP_id(createdProduct.getP_id());
        Assertions.assertEquals(expected, createdProduct);
    }

    @Test
    public void getProduct() {
        try {
            Product actual = pr.getProduct(product.getP_id());
            Product expected = new Product(product.getP_id(), "name", "desc", 12f, 15, null);
            Assertions.assertEquals(expected, actual);
        } catch(ResourceNotFoundException e)
        {
            e.printStackTrace();
        }


    }

    @Test
    public void updateProduct() {
        try {
            String newName = "new";
            product.setName(newName);
            Product actual = pr.updateProduct(product);
            Assertions.assertEquals(actual.getName(), newName);
        } catch(ResourceNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteProduct() {
        try {
            Product actual = pr.deleteProduct(product.getP_id());
            Assertions.assertEquals(product, actual);
        } catch(ResourceNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}
