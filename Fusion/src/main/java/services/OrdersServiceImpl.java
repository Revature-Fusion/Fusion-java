package services;

import models.Orders;
import repositories.OrdersRepo;

import java.util.List;

public class OrdersServiceImpl implements OrdersService{

    private OrdersRepo or;

    public OrdersServiceImpl(OrdersRepo or) {
        this.or = or;
    }

    @Override
    public Orders getOrder(int oID) {
        return or.getOrder(oID);
    }

    @Override
    public List<Orders> getOrderByUserID(int uID) {
        return or.getOrderByUserID(uID);
    }

    @Override
    public List<Orders> getAllOrders() {
        return or.getAllOrders();
    }

    @Override
    public Orders addOrder(Orders o) {
        return or.addOrder(o);
    }

    @Override
    public Orders updateOrders(Orders change) {
        return or.updateOrders(change);
    }

    @Override
    public Orders deleteOrders(int oID) {
        return or.deleteOrders(oID);
    }

    @Override
    public Orders deleteOrdersByUserID(int uID) {
        return or.deleteOrdersByUserID(uID);
    }

}
