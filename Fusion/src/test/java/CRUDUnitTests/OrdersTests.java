package CRUDUnitTests;

import models.OrderDetails;
import models.Orders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repositories.OrderDetailsRepo;
import repositories.OrderDetailsRepoImpl;
import repositories.OrdersRepo;
import repositories.OrdersRepoImpl;
import services.OrderDetailsService;
import services.OrderDetailsServiceImpl;
import services.OrdersService;
import services.OrdersServiceImpl;

import java.util.List;

public class OrdersTests {

    OrdersRepo or = new OrdersRepoImpl();
    OrdersService os = new OrdersServiceImpl(or);
    OrderDetailsRepo odr = new OrderDetailsRepoImpl();
    OrderDetailsService ods = new OrderDetailsServiceImpl(odr);

    @Test
    public void testGetOrder(){
        Orders orders = os.getOrder(999);
        Orders expectedOrders = new Orders(999, 2,1654613952000l, 1);
        Assertions.assertEquals(expectedOrders, orders);
    }

    @Test
    public void  getOrderByUserID(){
        List<Orders> orders = os.getOrderByUserID(2);
        Assertions.assertTrue(orders.size() > 0 && orders.size() < 150);
        Assertions.assertEquals(orders.get(orders.size()-1), new Orders(999, 2,1654613952000l, 1));
    }

    @Test
    public void getAllOrders(){
        List<Orders> orders = os.getAllOrders();
        Assertions.assertTrue(orders.size() > 0 && orders.size() < 150);
        Assertions.assertEquals(orders.get(orders.size()-1), new Orders(999,2,1654613952000l,1));
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
    public void testDeleteOrders() {
        Orders o = new Orders(3, 1,1654613955000l,1);

        Orders addedOrders = os.addOrder(o);

        Orders deletedOrders = os.deleteOrders(addedOrders.getoID());
        Assertions.assertEquals(addedOrders, deletedOrders);

        Orders deletedOrders2 = os.deleteOrders(addedOrders.getoID());
        Assertions.assertNull(deletedOrders2);
    }

    @Test
    public void testDeleteOrdersByUserID(){
          Orders o = new Orders(3, 1,1654633955000l,1);

          Orders addedOrders = os.addOrder(o);

          Orders deletedOrders = os.deleteOrdersByUserID(addedOrders.getuID());
          Assertions.assertNotNull(deletedOrders, "Should not be null");

          Orders deletedOrders2 = os.deleteOrdersByUserID(addedOrders.getuID());
          Assertions.assertNull(deletedOrders2, "Should be null");

          Orders o1 = new Orders(1, 1,1654613952000l, 1);
          o1 = os.addOrder(o1);

          ods.addOrderDetails( new OrderDetails(1,o1.getoID(),2,2) );
          ods.addOrderDetails( new OrderDetails(2,o1.getoID(),3,2) );
    }


}
