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
        List<OrderDetails> orderDetails = ods.getOrderDetailsByOrderID(53);
        Assertions.assertTrue(orderDetails.size() > 0 && orderDetails.size() < 150);
        Assertions.assertTrue(orderDetails.contains( new OrderDetails(15,53,3,2)));
    }

    @Test
    public void testCreateOrderDetails(){
    OrderDetails od = new OrderDetails(95, 999, 2, 10);
    OrderDetails addOrderDetails = ods.addOrderDetails(od);
    od.setoID(addOrderDetails.getoID());

    Assertions.assertEquals(od, addOrderDetails);
    ods.deleteOrderDetails(addOrderDetails.getoID());
    }
    @Test
    public void testUpdateOrderDetails(){
        OrderDetails od = new OrderDetails(95, 999, 2, 10);
        OrderDetails addOrderDetails = ods.addOrderDetails(od);
        OrderDetails orderDetailsToUpdate = new OrderDetails(addOrderDetails.getoDID(), 999,2,10);
        OrderDetails updateDetails = ods.updateOrderDetails(orderDetailsToUpdate);
        Assertions.assertNotEquals(addOrderDetails, updateDetails);
        Assertions.assertEquals(orderDetailsToUpdate, updateDetails);
        ods.deleteOrderDetails(updateDetails.getoDID());
    }

    @Test
    public void testDeleteOrderDetails(){

    }
    @Test
    public void testdeleteOrderDetailsByOrderID(){

    }


}
