package repositories;

import models.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
        if (product != null) {
            pr.deleteProduct(product.getP_id());
            product = null;
        }
        if (createdProduct != null) {
            pr.deleteProduct(createdProduct.getP_id());
            createdProduct = null;
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
        Product actual = pr.getProduct(product.getP_id());
        Product expected = new Product(product.getP_id(), "name", "desc", 12f, 15, null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateProduct() {
        String newName = "new";
        product.setName(newName);
        Product actual = pr.updateProduct(product);
        Assertions.assertEquals(actual.getName(), newName);
    }

    @Test
    public void deleteProduct() {
        Product actual = pr.deleteProduct(product.getP_id());
        Assertions.assertEquals(product, actual);
    }

    @Test
    public void negativeGetProduct() {
        Product actual = pr.getProduct(Integer.MAX_VALUE);
        Assertions.assertNull(actual);
    }

    @Test
    public void negativeUpdateProduct() {
        Product change = new Product();
        change.setP_id(Integer.MAX_VALUE);
        Product actual = pr.updateProduct(change);
        Assertions.assertNull(actual);
    }

    @Test
    public void negativeDeleteProduct() {
        Product actual = pr.deleteProduct(Integer.MAX_VALUE);
        Assertions.assertNull(actual);
    }
}
