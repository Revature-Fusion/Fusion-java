package repositories;

import models.Address;
import models.Product;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressRepoImpl implements AddressRepo {

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public Address createAddress(Address a) {
        String sql = "INSERT INTO address VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,a.getU_id());
            ps.setString(2, a.getAddress());
            ps.setString(3, a.getCity());
            ps.setString(4, a.getPostal_code());
            ps.setString(5, a.getCountry());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                return buildAddress(rs);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Address getAddress(int a_id) {
        String sql = "SELECT * FROM address WHERE a_id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, a_id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildAddress(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Address> getAddressByUser(int u_id) {
        String sql = "SELECT * FROM address WHERE u_id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, u_id);

            ResultSet rs = ps.executeQuery();

            List<Address> addresses = new ArrayList<>();

            while (rs.next()) {
                addresses.add(buildAddress(rs));
            }

            return addresses;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Address updateAddress(Address change) {
        String sql = "UPDATE address SET u_id=?, address=?, city=?, postal_code=?, country=? WHERE a_id=? RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, change.getU_id());
            ps.setString(2, change.getAddress());
            ps.setString(3, change.getCity());
            ps.setString(4, change.getPostal_code());
            ps.setString(5, change.getCountry());
            ps.setInt(6, change.getA_id());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildAddress(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Address deleteAddress(int a_id) {
        String sql = "DELETE FROM address WHERE a_id=? RETURNING *";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, a_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return buildAddress(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Address buildAddress(ResultSet rs) throws SQLException {
        return new Address(
                rs.getInt("a_id"),
                rs.getInt("u_id"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getString("postal_code"),
                rs.getString("country")
        );
    }
}
