package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import services.OrderDetailsService;
import services.OrdersService;

public class OrdersController {

    private OrdersService os;
    private Gson gson = new Gson();

    public OrdersController(OrdersService os) {
        this.os = os;
    }

    public Handler getAllOrders = (context) -> {

    };



}
