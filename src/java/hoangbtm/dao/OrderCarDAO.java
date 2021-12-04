/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.dao;

import hoangbtm.util.DBContext;
import hoangbtm.dto.OrderCarDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hoang
 */
public class OrderCarDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int addOrderReturnId(OrderCarDTO order) throws SQLException {
        try {
            String sql = "INSERT INTO [dbo].[orderCar]\n"
                    + "           ([accountID]\n"
                    + "           ,[total_price]\n"
                    + "           ,[discount]\n"
                    + "           ,[shipping_id])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getAccountId());
            ps.setDouble(2, order.getTotalPrice());
            ps.setString(3, order.getDiscount());
            ps.setInt(4, order.getShipping_id());

            if (ps.executeUpdate() != 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
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

    public ArrayList<OrderCarDTO> getAllOrderByAccount(int accountId) throws SQLException {
        try {
            String sql = "SELECT [orderId]\n"
                    + "      ,[accountID]\n"
                    + "      ,[create_date]\n"
                    + "      ,[total_price]\n"
                    + "      ,[discount]\n"
                    + "      ,[shipping_id]\n"
                    + "  FROM [dbo].[orderCar]\n"
                    + "  WHERE [accountID] = ?;";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();

            ArrayList<OrderCarDTO> listOrder = new ArrayList<>();
            while (rs.next()) {
                OrderCarDTO order = new OrderCarDTO(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
                listOrder.add(order);
            }
            return listOrder;
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

    public ArrayList<OrderCarDTO> getAllOrderByDate(String from, String to) throws SQLException {
        try {
            String sql = "SELECT [orderId]\n"
                    + "      ,[accountID]\n"
                    + "      ,[create_date]\n"
                    + "      ,[total_price]\n"
                    + "      ,[discount]\n"
                    + "      ,[shipping_id]\n"
                    + "  FROM [dbo].[orderCar]\n"
                    + "  WHERE [create_date] BETWEEN ? AND ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, from);
            ps.setString(2, to);
            rs = ps.executeQuery();

            ArrayList<OrderCarDTO> listOrder = new ArrayList<>();
            while (rs.next()) {
                OrderCarDTO order = new OrderCarDTO(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
                listOrder.add(order);
            }
            return listOrder;
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
