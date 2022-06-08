package app;

import controllers.AddressController;
import controllers.ProductController;
import io.javalin.Javalin;
import repositories.AddressRepo;
import repositories.AddressRepoImpl;
import repositories.ProductRepo;
import repositories.ProductRepoImpl;
import services.AddressService;
import services.AddressServiceImpl;
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

        AddressRepo ar = new AddressRepoImpl();
        AddressService as = new AddressServiceImpl(ar);
        AddressController ac = new AddressController(as);

        app.get("/products", pc.getAllProducts);
        app.get("/products/:id", pc.getProduct);
        app.post("/products/", pc.createProduct);
        app.put("/products/:id", pc.updateProduct);
        app.delete("/products/:id", pc.deleteProduct);

        app.post("/address", ac.createAddress);
        app.get("/address/:a_id", ac.getAddress);
        app.get("/address/:u_id", ac.getAddressByUser);
        app.put("/address/:a_id", ac.updateAddress);
        app.delete("/address/:a_id", ac.deleteAddress);


    }

}
