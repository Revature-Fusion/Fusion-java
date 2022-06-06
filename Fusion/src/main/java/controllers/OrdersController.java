package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.Orders;
import services.OrderDetailsService;
import services.OrdersService;

import java.util.List;

public class OrdersController {

    private OrdersService os;
    private Gson gson = new Gson();

    public OrdersController(OrdersService os) {
        this.os = os;
    }

    public Handler getAllOrders = (context) -> {
        List<Orders> orders = os.getAllOrders();
        String ordersJSON = gson.toJson(orders);
        context.result(ordersJSON);
    };

    public Handler getOrdersByUserID = (context) -> {
        int uID = Integer.parseInt(context.pathParam("uID"));
         List<Orders> orders = os.getOrderByUserID(uID);
         context.result(gson.toJson(orders));
    };

    public Handler getOrderById = (context) -> {

        int oID = Integer.parseInt(context.pathParam("oID"));
        Orders order = os.getOrder(oID);
        context.result(gson.toJson(order));
    };

    public Handler createOrder = (context) -> {
        Orders order = gson.fromJson(context.body(), Orders.class);

        order = os.addOrder(order);
        context.result(gson.toJson(order));
    };

    public Handler updateOrder = (context) -> {
        Orders order = gson.fromJson(context.body(), Orders.class);

        order = os.updateOrders(order);
        context.result(gson.toJson(order));
    };

    public Handler deleteOrder = (context) -> {
        int oID = Integer.parseInt(context.pathParam("oID"));

        Orders order = os.deleteOrders(oID);
        context.result(gson.toJson(order));
    };

    public Handler deleteOrdersByUserId = (context) -> {
        int uID = Integer.parseInt(context.pathParam("uID"));

        Orders order = os.deleteOrdersByUserID(uID);
        context.result(gson.toJson(order));
    };

}

