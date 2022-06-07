package repositories;

import models.OrderDetails;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsRepoImpl implements OrderDetailsRepo{

    public static Connection conn = JDBCConnection.getConnection();

    public OrderDetailsRepoImpl() {}

    @Override
    public OrderDetails getOrderDetails(int oDID) {
        String sql = "SELECT * FROM order_details WHERE od_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, oDID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildOrderDetails(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<OrderDetails> getOrderDetailsByOrderID(int oID) {
        String sql = "SELECT * FROM order_details WHERE o_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, oID);

            ResultSet rs = ps.executeQuery();

            List<OrderDetails> orderDetails = new ArrayList<>();

            while(rs.next()) {
                orderDetails.add(buildOrderDetails(rs));
            }

            return orderDetails;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        String sql = "SELECT * FROM order_details";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<OrderDetails> orderDetails = new ArrayList<>();

            while(rs.next()) {
                orderDetails.add(buildOrderDetails(rs));
            }

            return orderDetails;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public OrderDetails addOrderDetails(OrderDetails od) {
        String sql = "INSERT INTO order_details VALUES (DEFAULT,?,?,?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, od.getoID());
            ps.setInt(2, od.getpID());
            ps.setInt(3, od.getQuantity());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildOrderDetails(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public OrderDetails updateOrderDetails(OrderDetails change) {
        try {
            String sql = "UPDATE order_details SET o_id=?, p_id=?, quantity=? WHERE od_id=? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, change.getoID());
            ps.setInt(2, change.getpID());
            ps.setInt(3, change.getQuantity());
            ps.setInt(4, change.getoDID());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildOrderDetails(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public OrderDetails deleteOrderDetails(int oDID) {
        try {
            String sql = "DELETE FROM order_details WHERE od_id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, oDID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildOrderDetails(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public OrderDetails deleteOrderDetailsByOrderID(int oID) {
        try {
            String sql = "DELETE FROM order_details WHERE o_id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, oID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildOrderDetails(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private OrderDetails buildOrderDetails(ResultSet rs) throws SQLException {
        OrderDetails od = new OrderDetails();
        od.setoDID(rs.getInt("od_id"));
        od.setoID(rs.getInt("o_id"));
        od.setpID(rs.getInt("p_id"));
        od.setQuantity(rs.getInt("quantity"));

        return od;


    }

}
