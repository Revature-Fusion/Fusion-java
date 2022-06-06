package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.OrderDetails;
import services.OrderDetailsService;

import java.util.List;

public class OrderDetailsController {

    private OrderDetailsService ods;
    private Gson gson = new Gson();

    public OrderDetailsController(OrderDetailsService ods) {
        this.ods = ods;
    }

    public Handler getAllOrderDetails = (context) -> {
        List<OrderDetails> orderDetails = ods.getAllOrderDetails();
        String orderDetailsJSON = gson.toJson(orderDetails);
        context.result(orderDetailsJSON);
    };

    public Handler getOrderDetails = (context) -> {
        int oDID = Integer.parseInt(context.pathParam("oDID"));
        OrderDetails orderDetails = ods.getOrderDetails(oDID);
        context.result(gson.toJson(orderDetails));
    };

    public Handler getOrderDetailsByOrderID = (context) -> {
        int oID = Integer.parseInt(context.pathParam("oID"));
        List<OrderDetails> orderDetails = ods.getOrderDetailsByOrderID(oID);
        String orderDetailsJSON = gson.toJson(orderDetails);
        context.result(orderDetailsJSON);
    };

    public Handler createOrderDetails = (context) -> {
        OrderDetails orderDetails = gson.fromJson(context.body(), OrderDetails.class);

        orderDetails = ods.addOrderDetails(orderDetails);
        context.result(gson.toJson(orderDetails));
    };

    public Handler updateOrderDetails = (context) -> {
        OrderDetails orderDetails = gson.fromJson(context.body(), OrderDetails.class);

        orderDetails = ods.updateOrderDetails(orderDetails);
        context.result(gson.toJson(orderDetails));
    };

    public Handler deleteOrderDetails = (context) -> {
        int oDID = Integer.parseInt(context.pathParam("oDID"));

        OrderDetails orderDetails = ods.deleteOrderDetails(oDID);
        context.result(gson.toJson(orderDetails));
    };

    public Handler deleteOrderDetailsByOrderID = (context) -> {
        int oID = Integer.parseInt(context.pathParam("oID"));

        OrderDetails orderDetails = ods.deleteOrderDetailsByOrderID(oID);
        context.result(gson.toJson(orderDetails));
    };
}
