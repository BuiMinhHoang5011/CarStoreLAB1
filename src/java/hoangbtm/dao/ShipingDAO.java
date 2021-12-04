/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.dao;

import hoangbtm.util.DBContext;
import hoangbtm.dto.ShippingDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hoang
 */
public class ShipingDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int addShippingReturnId(ShippingDTO shipping) throws SQLException {
        try {
            String sql = "INSERT INTO [dbo].[Shipping]\n"
                    + "           ([name]\n"
                    + "           ,[phone]\n"
                    + "           ,[address]\n"
                    + "           ,[note])\n"
                    + "     VALUES"
                    + "           (?,?,?,?)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, shipping.getName());
            ps.setString(2, shipping.getPhone());
            ps.setString(3, shipping.getAddress());
            ps.setString(4, shipping.getNote());

            if (ps.executeUpdate() != 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        finally {
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
}
