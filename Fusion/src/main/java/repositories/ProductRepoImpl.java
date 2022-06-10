package repositories;

import exceptions.ResourceNotFoundException;
import models.Product;
import util.JDBCConnection;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ProductRepoImpl implements ProductRepo {

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public Product getProduct(int id) throws ResourceNotFoundException {
        String sql = "Select * from products where p_id = ?";
        try
        {
            PreparedStatement ps1 = conn.prepareStatement(sql);
            ps1.setInt(1,id);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next())
            {
                return buildProduct(rs1);
            } else {
                throw new ResourceNotFoundException("Product Not Found");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        String sql = "Select * from products";
        try
        {
            PreparedStatement ps1 = conn.prepareStatement(sql);
            ResultSet rs1 = ps1.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs1.next())
            {
                products.add(buildProduct(rs1));
            }
            return products;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        String sql = "Insert into products values (DEFAULT,?,?,?,?,?) returning *";
        try
        {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getDesc());
            ps.setFloat(2, product.getPrice());
            ps.setInt(3, product.getStock());
            ps.setString(4, product.getPicture());
            ps.setString(5, product.getName());

            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return buildProduct(rs);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product updateProduct(Product change) throws ResourceNotFoundException {
        try
        {
            String sql = "UPDATE products SET \"desc\"=?, price=?, stock=?, picture=?, name=? WHERE p_id=? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, change.getDesc());
            ps.setFloat(2, change.getPrice());
            ps.setInt(3, change.getStock());
            ps.setString(4, change.getPicture());
            ps.setString(5, change.getName());
            ps.setInt(6, change.getP_id());

            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return buildProduct(rs);
            } else {
                throw new ResourceNotFoundException("Product Not Found");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product deleteProduct(int id) throws ResourceNotFoundException {
        String sql = "delete from products where p_id = ? returning *";
        try
        {
            PreparedStatement ps1 = conn.prepareStatement(sql);
            ps1.setInt(1,id);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next())
            {
                return buildProduct(rs1);
            }else {
                throw new ResourceNotFoundException("Product Not Found");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private Product buildProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("p_id"),
                rs.getString("name"),
                rs.getString("desc"),
                rs.getFloat("price"),
                rs.getInt("stock"),
                rs.getString("picture")
                );
    }

    public static void main(String[] args) throws Exception {
        ProductRepo pr = new ProductRepoImpl();
//        pr.createProduct(new Product(1, "blah", "desc", 12.00F, 7, null));
//        System.out.println(pr.getProduct(3));
//        System.out.println(pr.getAllProducts());
//        System.out.println(pr.updateProduct(new Product(3, "123", "desc", 12.00F, 90, null)));
//        pr.deleteProduct(1);
//        System.out.println("deleted");


//        addPictureToProduct(43, "src/main/images/soldering_iron.png");

    }

    // It is difficult to add images with SQL code, so this  method is to help devs manually add images to the database
//    private static void addPictureToProduct(int pId, String filePath) throws Exception {
//        ProductRepo pr = new ProductRepoImpl();
//
//        Product product = pr.getProduct(pId);
//        File file = new File(filePath);
//        byte[] byteArray = new byte[(int) file.length()];
//        FileInputStream fis = new FileInputStream(file);
//        fis.read(byteArray);
//        String base64Array = Base64.getEncoder().encode(byteArray);
//        product.setPicture(base64Array);
//
//        pr.updateProduct(product);
//    }
}
