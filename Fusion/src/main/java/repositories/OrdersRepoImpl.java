package repositories;

import models.Orders;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersRepoImpl implements OrdersRepo{

    public static Connection conn = JDBCConnection.getConnection();

    public OrdersRepoImpl() {}

    @Override
    public Orders getOrder(int oID) {
        String sql = "SELECT * FROM orders WHERE o_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, oID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildOrder(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public List<Orders> getOrderByUserID(int uID) {
        String sql = "SELECT * FROM orders WHERE u_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, uID);

            ResultSet rs = ps.executeQuery();

            List<Orders> orders = new ArrayList<>();

            while(rs.next()) {
                orders.add(buildOrder(rs));
            }

            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Orders> getAllOrders() {
        String sql = "SELECT * FROM orders";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Orders> orders = new ArrayList<>();

            while(rs.next()) {
                orders.add(buildOrder(rs));
            }

            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Orders addOrder(Orders o) {
        String sql = "INSERT INTO orders VALUES (DEFAULT,?,?,?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, o.getuID());
            ps.setLong(2, o.getDateOfPurchasing());
            ps.setInt(3, o.getaID());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildOrder(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Orders updateOrders(Orders change) {
        try {
            String sql = "UPDATE orders SET u_id=?, date_of_purchase=?, a_id=? WHERE o_id=? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, change.getuID());
            ps.setLong(2, change.getDateOfPurchasing());
            ps.setInt(3, change.getaID());
            ps.setInt(4, change.getoID());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildOrder(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Orders deleteOrders(int oID) {
        try {
            String sql = "DELETE FROM orders WHERE o_id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, oID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildOrder(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Orders deleteOrdersByUserID(int uID) {
        try {
            String sql = "DELETE FROM orders WHERE u_id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, uID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildOrder(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Orders buildOrder(ResultSet rs) throws SQLException {
        Orders o = new Orders(1, 1, 1654613952000l, 1);
        o.setoID(rs.getInt("o_id"));
        o.setuID(rs.getInt("u_id"));
        o.setDateOfPurchasing(rs.getLong("date_of_purchase"));
        o.setaID(rs.getInt("a_id"));

        return o;
    }

}
