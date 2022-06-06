package services;

import models.OrderDetails;
import repositories.OrderDetailsRepo;

import java.util.List;

public class OrderDetailsServiceImpl implements OrderDetailsService{

    private OrderDetailsRepo odr;

    public OrderDetailsServiceImpl(OrderDetailsRepo odr){
        this.odr = odr;
    }


    @Override
    public OrderDetails getOrderDetails(int oDID) {
        return odr.getOrderDetails(oDID);
    }

    @Override
    public OrderDetails getOrderDetailsByOrderID(int oID) {
        return odr.getOrderDetailsByOrderID(oID);
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return odr.getAllOrderDetails();
    }

    @Override
    public OrderDetails addOrderDetails(OrderDetails od) {
        return odr.addOrderDetails(od);
    }

    @Override
    public OrderDetails updateOrderDetails(OrderDetails change) {
        return odr.updateOrderDetails(change);
    }

    @Override
    public OrderDetails deleteOrderDetails(int oDID) {
        return odr.deleteOrderDetails(oDID);
    }

    @Override
    public OrderDetails deleteOrderDetailsByOrderID(int oID) {
        return odr.deleteOrderDetailsByOrderID(oID);
    }
}
