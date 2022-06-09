package app;

import controllers.OrderDetailsController;
import controllers.OrdersController;
import io.javalin.Javalin;
import repositories.OrderDetailsRepo;
import repositories.OrderDetailsRepoImpl;
import repositories.OrdersRepo;
import repositories.OrdersRepoImpl;
import services.OrderDetailsService;
import services.OrderDetailsServiceImpl;
import services.OrdersService;
import services.OrdersServiceImpl;
import controllers.AddressController;
import controllers.ProductController;
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

        OrdersRepo or = new OrdersRepoImpl();
        OrdersService os = new OrdersServiceImpl(or);
        OrdersController oc = new OrdersController(os);

        OrderDetailsRepo odr = new OrderDetailsRepoImpl();
        OrderDetailsService ods = new OrderDetailsServiceImpl(odr);
        OrderDetailsController odc = new OrderDetailsController(ods);

        ProductRepo pr = new ProductRepoImpl();
        ProductService ps = new ProductServiceImpl(pr);
        ProductController pc = new ProductController(ps);

        AddressRepo ar = new AddressRepoImpl();
        AddressService as = new AddressServiceImpl(ar);
        AddressController ac = new AddressController(as);

        // For orders
        app.get("/orders", oc.getAllOrders);
        app.get("/orders/:oID", oc.getOrderById);
        app.get("/ordersByUID/:uID", oc.getOrdersByUserID); // To get orders by userID
        app.post("/orders/", oc.createOrder);
        app.put("/orders/:oID", oc.updateOrder);
        app.delete("/orders/:oID", oc.deleteOrder);
        app.delete("/ordersByUID/:uID", oc.deleteOrdersByUserId);   // To delete orders by userID

        // For order_details
        app.get("/orderDetails", odc.getAllOrderDetails);
        app.get("/orderDetails/:oDID", odc.getOrderDetails);
        app.get("/orderDetailsByOID/:oID", odc.getOrderDetailsByOrderID); // To get order details by orderID
        app.post("/orderDetails/", odc.createOrderDetails);
        app.put("/orderDetails/:oDID", odc.updateOrderDetails);
        app.delete("/orderDetails/:oDID", odc.deleteOrderDetails);
        app.delete("/orderDetailsByOID/:oID", odc.deleteOrderDetailsByOrderID);   // To delete order details by orderID

        app.get("/products", pc.getAllProducts);
        app.get("/products/:id", pc.getProduct);
        app.post("/products/", pc.createProduct);
        app.put("/products/:id", pc.updateProduct);
        app.patch("/products/:id", pc.updateProductStock);
        app.delete("/products/:id", pc.deleteProduct);

        app.post("/address", ac.createAddress);
        app.get("/address/:a_id", ac.getAddress);
        app.get("/address/:u_id", ac.getAddressByUser);
        app.put("/address/:a_id", ac.updateAddress);
        app.delete("/address/:a_id", ac.deleteAddress);


    }

}
