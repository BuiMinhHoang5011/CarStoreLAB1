/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.dao;

import hoangbtm.util.DBContext;
import hoangbtm.dto.CategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hoang
 */
public class CategoryDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<CategoryDTO> getAllCategory() throws SQLException {
        try {
            String sql = "SELECT [category_id]\n"
                    + "      ,[categoryName]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[category] WHERE [status] = 1 ";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<CategoryDTO> listCategory = new ArrayList<>();
            while (rs.next()) {
                CategoryDTO category = new CategoryDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
                listCategory.add(category);
            }
            return listCategory;
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

    public int addCategory(String name) throws SQLException {
        try {
            String sql = "INSERT INTO [dbo].[category]\n"
                    + "           ([categoryName]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?,1)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
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

    public CategoryDTO checkDuplicateName(String name) throws SQLException {
        try {
            String sql = "SELECT [category_id]\n"
                    + "      ,[categoryName]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[category]\n"
                    + "  WHERE [categoryName] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (rs.next()) {
                CategoryDTO category = new CategoryDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
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
