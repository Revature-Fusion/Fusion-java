package app;

import controllers.ProductController;
import io.javalin.Javalin;
import models.Product;
import repositories.ProductRepo;
import repositories.ProductRepoImpl;
import services.ProductService;
import services.ProductServiceImpl;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());

        establishRoutes(app);

        app.start();

    }

    private static void establishRoutes(Javalin app) {

        ProductRepo pr = new ProductRepoImpl();
        ProductService ps = new ProductServiceImpl(pr);
        ProductController pc = new ProductController(ps);

        app.get("/products", pc.getAllProducts);
        app.get("/products/:id", pc.getProduct);
        app.post("/products/", pc.createProduct);
        app.put("/products/:id", pc.updateProduct);
        app.delete("/products/:id", pc.deleteProduct);

    }

}
