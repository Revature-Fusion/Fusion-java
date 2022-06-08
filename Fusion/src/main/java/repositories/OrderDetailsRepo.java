package repositories;

import models.OrderDetails;

import java.util.List;

public interface OrderDetailsRepo {

    public OrderDetails getOrderDetails(int oDID);

    public List<OrderDetails> getOrderDetailsByOrderID(int oID);

    public List<OrderDetails> getAllOrderDetails();

    public OrderDetails addOrderDetails(OrderDetails od);

    public OrderDetails updateOrderDetails(OrderDetails change);

    public OrderDetails deleteOrderDetails(int oDID);

    public OrderDetails deleteOrderDetailsByOrderID(int oID);

}
