package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.OrderDetails;
import models.Orders;
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
        String ordersJSON = gson.toJson(orderDetails);
        context.result(ordersJSON);
    };

    public Handler getOrderDetailsByOrderID = (context) -> {
        int oID = Integer.parseInt(context.pathParam("oID"));
        List<Order> orders = ods.getOrderByUserID(uID);
        context.result(gson.toJson(orders));
    };


}
