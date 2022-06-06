package repositories;

import models.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ProductRepoTest {

    static ProductRepo pr = new ProductRepoImpl();

    static Product product;

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
    }

    @Test
    public void getProduct() {
        Product actual = pr.getProduct(product.getP_id());
        Product expected = new Product(product.getP_id(), "name", "desc", 12f, 15, null);
        Assertions.assertEquals(expected, actual);
    }
}
