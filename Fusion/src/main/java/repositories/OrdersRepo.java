package repositories;

import models.Orders;

import java.util.List;

public interface OrdersRepo {

    public Orders getOrder(int oID);

    public Orders getOrderByUserID(int uID);

    public List<Orders> getAllOrders();

    public Orders updateOrders(Orders change);

    public Orders deleteOrders(int oID);

    public Orders deleteOrdersByUserID(int uID);


}