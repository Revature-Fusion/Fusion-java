package CRUDTests;

import models.Orders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repositories.OrdersRepo;
import repositories.OrdersRepoImpl;
import services.OrdersService;
import services.OrdersServiceImpl;

import java.util.List;

public class OrdersTests {

    OrdersRepo or = new OrdersRepoImpl();
    OrdersService os = new OrdersServiceImpl(or);

    @Test
    public void testGetOrder(){
        Orders orders = os.getOrder(1);
        Orders expectedOrders = new Orders(1, 1,1654613952000l, 1);
        Assertions.assertEquals(expectedOrders, orders);
    }

    @Test
    public void  getOrderByUserID(){
        List<Orders> orders = os.getOrderByUserID(1);
        Assertions.assertTrue(orders.size() > 0 && orders.size() < 150);
        Assertions.assertEquals(orders.get(0), new Orders(1,1,1654613952000l,1));
    }

    @Test
    public void getAllOrders(){
        List<Orders> orders = os.getAllOrders();
        Assertions.assertTrue(orders.size() > 0 && orders.size() < 150);
        Assertions.assertEquals(orders.get(0), new Orders(1,1,1654613952000l,1));
    }

    @Test
    public void addOrder(){
        Orders o = new Orders(3, 1,1654613955000l,1);

        Orders addedOrders = os.addOrder(o);

        o.setoID(addedOrders.getoID());
        Assertions.assertEquals(o, addedOrders);

        os.deleteOrders(addedOrders.getoID());
    }

    @Test
    public void updateOrders(){
        Orders o = new Orders(3, 1,1654613955000l,1);

        Orders addedOrders = os.addOrder(o);

        Orders ordersToUpdate = new Orders(addedOrders.getoID(), 1, 1654615955000l, 1);

        Orders updatedOrders = os.updateOrders(ordersToUpdate);

        Assertions.assertNotEquals(addedOrders, updatedOrders);
        Assertions.assertEquals(ordersToUpdate, updatedOrders);

        os.deleteOrders(updatedOrders.getoID());
    }

    @Test
    public void testDeleteLogin() {
        Orders o = new Orders(3, 1,1654613955000l,1);

        Orders addedOrders = os.addOrder(o);

        Orders deletedOrders = os.deleteOrders(addedOrders.getoID());
        Assertions.assertEquals(addedOrders, deletedOrders);

        Orders deletedOrders2 = os.deleteOrders(addedOrders.getoID());
        Assertions.assertNull(deletedOrders2);
    }

    @Test
    public void testDeleteLoginByUserID() {
//        Orders o = new Orders(3, 1,1654613955000l,1);
//
//        Orders addedOrders = os.addOrder(o);
//
//        Orders deletedOrders = os.deleteOrdersByUserID(addedOrders.geuID());
//        Assertions.assertEquals(addedOrders, deletedOrders);
//
//        Orders deletedOrders2 = os.deleteOrders(addedOrders.getoID());
//        Assertions.assertNull(deletedOrders2);
    }


}
