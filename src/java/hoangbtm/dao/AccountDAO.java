/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.dao;

import hoangbtm.util.DBContext;
import hoangbtm.dto.AccountDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hoang
 */
public class AccountDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public AccountDTO login(String username, String password) throws SQLException {
        try {
            String sql = "SELECT [userId]\n"
                    + "      ,[userName]\n"
                    + "      ,[password]\n"
                    + "      ,[displayName]\n"
                    + "      ,[address]\n"
                    + "      ,[phone]\n"
                    + "      ,[roll_id]\n"
                    + "      ,[status]\n"
                    + "      ,[create_date]\n"
                    + "  FROM [dbo].[account]\n"
                    + "  WHERE [userName] = ? AND [password] = ? AND status = 1";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                AccountDTO account = new AccountDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getDate(9));
                return account;
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

    public int register(AccountDTO account) throws SQLException {
        try {
            String sql = "INSERT INTO [dbo].[account]\n"
                    + "           ([userName]\n"
                    + "           ,[password]\n"
                    + "           ,[displayName]\n"
                    + "           ,[address]\n"
                    + "           ,[phone]\n"
                    + "           ,[roll_id]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,1,1)";

            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, account.getUserName());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getDisplayName());
            ps.setString(4, account.getAddress());
            ps.setString(5, account.getPhone());
            
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
}
