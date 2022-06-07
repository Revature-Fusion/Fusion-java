package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.Address;
import services.AddressService;

import java.util.List;


public class AddressController {

    private AddressService as;

    private Gson gson = new Gson();

    public AddressController(AddressService as) {
        this.as = as;
    }

    public Handler createAddress = (context) -> {
        Address a = gson.fromJson(context.body(), Address.class);

        a = as.createAddress(a);
        context.result(gson.toJson(a));
        context.status(201);
    };

    public Handler getAddress = (context) -> {

        int a_id = Integer.parseInt(context.pathParam("a_id"));
        Address a = as.getAddress(a_id);
        context.result(gson.toJson(a));

    };

    public Handler getAddressByUser = (context) -> {

        int u_id = Integer.parseInt(context.pathParam("u_id"));

        List<Address> addresses = as.getAddressByUser(u_id);
        String addressesJSON = gson.toJson(addresses);
        context.result(addressesJSON);

    };

    public Handler updateAddress = (context) -> {

        int a_id = Integer.parseInt(context.pathParam("a_id"));

        Address change = gson.fromJson(context.body(), Address.class);
        change.setA_id(a_id);

        change = as.updateAddress(change);
        context.result(gson.toJson(change));

    };

    public Handler deleteAddress = (context) -> {

        int a_id = Integer.parseInt(context.pathParam("a_id"));
        Address a = as.deleteAddress(a_id);
        context.status(204);
    };

}
