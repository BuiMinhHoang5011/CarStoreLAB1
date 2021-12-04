/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.dao;

import hoangbtm.util.DBContext;
import hoangbtm.dto.CartDTO;
import hoangbtm.dto.OrderCarDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hoang
 */
public class OrderCarDetailDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int addOrderDetailReturnId(ArrayList<CartDTO> listCart, int orderId) throws SQLException {
        try {
            String sql = "INSERT INTO [dbo].[orderCar_Detail]\n"
                    + "           ([orderId]\n"
                    + "           ,[product_id]\n"
                    + "           ,[product_name]\n"
                    + "           ,[product_price]\n"
                    + "           ,[quantity]\n"
                    + "           ,[product_image])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);

            int[] arr = {};
            for (CartDTO cart : listCart) {
                ps.setInt(1, orderId);
                ps.setInt(2, cart.getCarId());
                ps.setString(3, cart.getCarName());
                ps.setDouble(4, cart.getCarPrice());
                ps.setInt(5, cart.getQuantity());
                ps.setString(6, cart.getCarImg());
                ps.addBatch();
            }

            arr = ps.executeBatch();
            return arr.length;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return 0;
    }

    public ArrayList<OrderCarDetailDTO> getOrderDetailByOrderId(int orderId) throws SQLException {
        try {
            String sql = "SELECT [order_detailID]\n"
                    + "      ,[orderId]\n"
                    + "      ,[product_id]\n"
                    + "      ,[product_name]\n"
                    + "      ,[product_price]\n"
                    + "      ,[quantity]\n"
                    + "      ,[product_image]\n"
                    + "  FROM [dbo].[orderCar_Detail]\n"
                    + "  WHERE [orderId] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();

            ArrayList<OrderCarDetailDTO> listOrderDetail = new ArrayList<>();
            while (rs.next()) {
                OrderCarDetailDTO orderDetail = new OrderCarDetailDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7));
                listOrderDetail.add(orderDetail);
            }
            return listOrderDetail;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public ArrayList<OrderCarDetailDTO> getOrderDetailByBookName(String name, int orderId) throws SQLException {
        try {
            String sql = "SELECT [order_detailID]\n"
                    + "      ,[orderId]\n"
                    + "      ,[product_id]\n"
                    + "      ,[product_name]\n"
                    + "      ,[product_price]\n"
                    + "      ,[quantity]\n"
                    + "      ,[product_image]\n"
                    + "  FROM [dbo].[orderCar_Detail]\n"
                    + "  WHERE [product_name] like ? and [orderId] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ps.setInt(2, orderId);
            rs = ps.executeQuery();

            ArrayList<OrderCarDetailDTO> listOrderDetail = new ArrayList<>();
            while (rs.next()) {
                OrderCarDetailDTO orderDetail = new OrderCarDetailDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7));
                listOrderDetail.add(orderDetail);
            }
            return listOrderDetail;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
