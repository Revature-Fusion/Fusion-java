package controllers;

import com.google.gson.Gson;
import models.Product;
import services.ProductService;

import java.util.List;
import io.javalin.http.Handler;

public class ProductController {

    private ProductService ps;
    private Gson gson = new Gson();

    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    public Handler getAllProducts = (context) -> {

        List<Product> products = ps.getAllProducts();
        String productsJSON = gson.toJson(products);
        context.result(productsJSON);

    };

    public Handler getProduct = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Product p = ps.getProduct(id);
        context.result(gson.toJson(p));

    };

    public Handler createProduct = (context) -> {

        Product p = gson.fromJson(context.body(), Product.class);

        p = ps.createProduct(p);

        if(p != null) {
            context.result(gson.toJson(p));
            context.status(201);
        } else {
            context.status(404);
        }

    };

    public Handler updateProduct = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Product change = gson.fromJson(context.body(), Product.class);
        change.setP_id(id);

        change = ps.updateProduct(change);
        context.result(gson.toJson(change));

    };

    public Handler updateProductStock = (context) -> {
            int id = Integer.parseInt(context.pathParam("id"));
            int amount = gson.fromJson(context.body(), Product.class).getStock();
            Product change = ps.updateProductStock(id, amount);
            context.result(gson.toJson(change));
            context.status(404);

    };

    public Handler deleteProduct = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Product p = ps.deleteProduct(id);
        context.status(204);

    };


}
