package services;

import models.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

    public OrderDetails getOrderDetails(int oDID);

    public OrderDetails getOrderDetailsByOrderID(int oID);

    public List<OrderDetails> getAllOrderDetails();

    public OrderDetails addOrderDetails(OrderDetails od);

    public OrderDetails updateOrderDetails(OrderDetails change);

    public OrderDetails deleteOrderDetails(int oDID);

    public OrderDetails deleteOrderDetailsByOrderID(int oID);

}
