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

public class OrderDetailsTests {

    OrdersRepo or = new OrdersRepoImpl();
    OrdersService os = new OrdersServiceImpl(or);
    OrderDetailsRepo odr = new OrderDetailsRepoImpl();
    OrderDetailsService ods = new OrderDetailsServiceImpl(odr);

    @Test
    public void testgetAllOrderDetails(){
        List<OrderDetails> orderDetails = ods.getAllOrderDetails();
        Assertions.assertTrue(orderDetails.size() > 0 && orderDetails.size() < 150);
        Assertions.assertTrue(orderDetails.contains( new OrderDetails(1,999,2,3)));

    }

    @Test
    public void testGetOrderDetail(){
        OrderDetails orderdetails = ods.getOrderDetails(1);
        OrderDetails expectedDetails = new OrderDetails(1,999,2,3);
        Assertions.assertEquals(expectedDetails, orderdetails);
    }
    @Test
    public void testGetOrderDetailsByOrderID(){
        List<OrderDetails> orderDetails = ods.getOrderDetailsByOrderID(999);
        Assertions.assertTrue(orderDetails.size() > 0 && orderDetails.size() < 150);
        Assertions.assertTrue(orderDetails.contains( new OrderDetails(1,999,2,3)));
    }

    @Test
    public void testCreateOrderDetails(){
    OrderDetails od = new OrderDetails(95, 999, 2, 10);
    OrderDetails addOrderDetails = ods.addOrderDetails(od);
    od.setoDID(addOrderDetails.getoDID());

    Assertions.assertEquals(od, addOrderDetails);
    ods.deleteOrderDetails(addOrderDetails.getoDID());
    }
    @Test
    public void testUpdateOrderDetails(){
        OrderDetails od = new OrderDetails(95, 999, 2, 10);
        OrderDetails addOrderDetails = ods.addOrderDetails(od);
        OrderDetails orderDetailsToUpdate = new OrderDetails(addOrderDetails.getoDID(), 999,2,15);
        OrderDetails updateDetails = ods.updateOrderDetails(orderDetailsToUpdate);
        Assertions.assertNotEquals(addOrderDetails, updateDetails);
        Assertions.assertEquals(orderDetailsToUpdate, updateDetails);
        ods.deleteOrderDetails(updateDetails.getoDID());
    }

    @Test
    public void testDeleteOrderDetails(){
        OrderDetails od = new OrderDetails(4,998,3,5);

        OrderDetails addedOrderDetails = ods.addOrderDetails(od);

        OrderDetails deletedOrderDetails = ods.deleteOrderDetails(addedOrderDetails.getoDID());
        Assertions.assertEquals(addedOrderDetails, deletedOrderDetails);

        OrderDetails deletedOrderDetails2 = ods.deleteOrderDetails(addedOrderDetails.getoID());
        Assertions.assertNull(deletedOrderDetails2);
    }
    @Test
    public void testdeleteOrderDetailsByOrderID(){

        OrderDetails deletedOrderDetails = ods.deleteOrderDetailsByOrderID(998);

        Assertions.assertNotNull(deletedOrderDetails, "Should not be null");

        OrderDetails deletedOrderDetails2 = ods.deleteOrderDetailsByOrderID(998);

        Assertions.assertNull(deletedOrderDetails2, "Should be null");

        ods.addOrderDetails( new OrderDetails(2,998,3,5) );
        ods.addOrderDetails( new OrderDetails(3,998,3,5) );

    }


}
