/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.dao;

import hoangbtm.util.DBContext;
import hoangbtm.dto.DiscountCheckDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hoang
 */
public class DiscountCheckDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int addDiscountCheck(int d_id, int accountId) throws SQLException {
        try {
            String sql = "INSERT INTO [dbo].[discountCheck]\n"
                    + "           ([d_id]\n"
                    + "           ,[userId])\n"
                    + "     VALUES\n"
                    + "           (?,?)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, d_id);
            ps.setInt(2, accountId);

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

    public ArrayList<DiscountCheckDTO> getDiscountUsingByAccountId(int accountId) throws SQLException {
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[d_id]\n"
                    + "      ,[userId]\n"
                    + "  FROM [dbo].[discountCheck]\n"
                    + "  WHERE [userId] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, accountId);

            rs = ps.executeQuery();
            ArrayList<DiscountCheckDTO> listDiscountCheck = new ArrayList<>();
            while (rs.next()) {
                DiscountCheckDTO discount = new DiscountCheckDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                listDiscountCheck.add(discount);
            }
            return listDiscountCheck;
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
