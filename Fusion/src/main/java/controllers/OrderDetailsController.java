package controllers;

import com.google.gson.Gson;
import services.OrderDetailsService;

public class OrderDetailsController {

    private OrderDetailsService ods;
    private Gson gson = new Gson();

    public OrderDetailsController(OrderDetailsService ods) {
        this.ods = ods;
    }




}
