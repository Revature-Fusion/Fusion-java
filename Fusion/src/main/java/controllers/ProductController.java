package controllers;

import com.google.gson.Gson;
import exceptions.ResourceNotFoundException;
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
        try {
            int id = Integer.parseInt(context.pathParam("id"));
            Product p = ps.getProduct(id);
            context.result(gson.toJson(p));
        } catch (ResourceNotFoundException e) {
            context.status(404);
            context.result(e.getMessage());
        }


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

        try {
            int id = Integer.parseInt(context.pathParam("id"));
            Product change = gson.fromJson(context.body(), Product.class);
            change.setP_id(id);

            change = ps.updateProduct(change);
            context.result(gson.toJson(change));
        } catch (ResourceNotFoundException e) {
            context.status(404);
            context.result(e.getMessage());
        }

    };

    public Handler updateProductStock = (context) -> {
        try {
            int id = Integer.parseInt(context.pathParam("id"));
            int amount = gson.fromJson(context.body(), Product.class).getStock();
            Product change = ps.updateProductStock(id, amount);
            context.result(gson.toJson(change));
        } catch (ResourceNotFoundException e) {
            context.status(404);
            context.result(e.getMessage());
        }
    };

    public Handler deleteProduct = (context) -> {
        try {
            int id = Integer.parseInt(context.pathParam("id"));
            Product p = ps.deleteProduct(id);
            context.status(204);
        } catch (ResourceNotFoundException e) {
            context.status(404);
            context.result(e.getMessage());
        }


    };


}
