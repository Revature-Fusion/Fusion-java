package services;

import models.Orders;

import java.util.List;

public interface OrdersService {

    public Orders getOrder(int oID);

    public Orders getOrderByUserID(int uID);

    public List<Orders> getAllOrders();

    public Orders addOrder(Orders o);

    public Orders updateOrders(Orders change);

    public Orders deleteOrders(int oID);

    public Orders deleteOrdersByUserID(int uID);

}
