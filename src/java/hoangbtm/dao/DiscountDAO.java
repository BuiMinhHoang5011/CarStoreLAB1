/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.dao;

import hoangbtm.util.DBContext;
import hoangbtm.dto.DiscountDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hoang
 */
public class DiscountDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public double getPercentByDiscountName(String name) throws SQLException {
        try {
            String sql = "SELECT [d_id]\n"
                    + "      ,[d_name]\n"
                    + "      ,[d_percent]\n"
                    + "      ,[d_day]\n"
                    + "  FROM [dbo].[discount]\n"
                    + "  WHERE [d_name] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();

            double percent = 0;
            if (rs.next()) {
                percent = rs.getDouble(3);
                return percent;
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

    public int getDiscountIdByName(String name) throws SQLException {
        try {
            String sql = "SELECT [d_id]\n"
                    + "  FROM [dbo].[discount]\n"
                    + "  WHERE [d_name] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();

            int percent = 0;
            if (rs.next()) {
                percent = rs.getInt(1);
                return percent;
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

    public ArrayList<DiscountDTO> getAllDiscount() throws SQLException {
        try {
            String sql = "SELECT [d_id]\n"
                    + "      ,[d_name]\n"
                    + "      ,[d_percent]\n"
                    + "      ,[d_day]\n"
                    + "  FROM [dbo].[discount]\n";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<DiscountDTO> listDiscount = new ArrayList<>();
            while (rs.next()) {
                DiscountDTO discount = new DiscountDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4));
                listDiscount.add(discount);
            }
            return listDiscount;
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

    public int AddNewDiscount(String discountName, double percent) throws SQLException {
        try {
            String sql = "INSERT INTO [dbo].[discount]\n"
                    + "           ([d_name]\n"
                    + "           ,[d_percent])\n"
                    + "     VALUES\n"
                    + "           (?,?)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, discountName);
            ps.setDouble(2, percent);
            return ps.executeUpdate();

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

    public DiscountDTO checkDuplicateDiscount(String name) throws SQLException {
        try {
            String sql = "SELECT [d_id]\n"
                    + "      ,[d_name]\n"
                    + "      ,[d_percent]\n"
                    + "      ,[d_day]\n"
                    + "  FROM [dbo].[discount]\n"
                    + "  WHERE [d_name] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (rs.next()) {
                DiscountDTO category = new DiscountDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4));
                return category;
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
        return null;
    }
}

