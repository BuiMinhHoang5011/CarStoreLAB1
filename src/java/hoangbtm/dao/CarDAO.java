/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.dao;

import hoangbtm.util.DBContext;
import hoangbtm.dto.CarDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hoang
 */
public class CarDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<CarDTO> getAllCar() throws SQLException {
        try {
            String sql = "SELECT [carID]\n"
                    + "      ,[category_id]\n"
                    + "      ,[car_name]\n"
                    + "      ,[quantity]\n"
                    + "      ,[price]\n"
                    + "      ,[description]\n"
                    + "      ,[color]\n"
                    + "      ,[image]\n"
                    + "      ,[create_date]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[Car] WHERE [status] =1 AND [quantity] > 0";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<CarDTO> listCar = new ArrayList<>();
            while (rs.next()) {
                CarDTO car = new CarDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getInt(10));
                listCar.add(car);
            }
            return listCar;
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

    public ArrayList<CarDTO> searchCarByCategory(int id) throws SQLException {
        try {
            String sql = "SELECT [carID]\n"
                    + "      ,[category_id]\n"
                    + "      ,[car_name]\n"
                    + "      ,[quantity]\n"
                    + "      ,[price]\n"
                    + "      ,[description]\n"
                    + "      ,[color]\n"
                    + "      ,[image]\n"
                    + "      ,[create_date]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[Car]\n"
                    + "  WHERE [category_id] = ? AND [status] =1 AND [quantity] > 0";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            ArrayList<CarDTO> listSearchCar = new ArrayList<>();
            while (rs.next()) {
                CarDTO searchCar = new CarDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getInt(10));
                listSearchCar.add(searchCar);
            }
            return listSearchCar;
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

    public ArrayList<CarDTO> searchCar(String name, double min, double max) throws SQLException {
        try {
            String sql = "SELECT [carID]\n"
                    + "      ,[category_id]\n"
                    + "      ,[car_name]\n"
                    + "      ,[quantity]\n"
                    + "      ,[price]\n"
                    + "      ,[description]\n"
                    + "      ,[color]\n"
                    + "      ,[image]\n"
                    + "      ,[create_date]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[Car]\n"
                    + "  WHERE [car_name] like ? AND [price] BETWEEN ? AND ? AND [status] = 1 AND [quantity] > 0";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, "%" + name + "%");
            ps.setDouble(2, min);
            ps.setDouble(3, max);

            rs = ps.executeQuery();

            ArrayList<CarDTO> listSearchCar = new ArrayList<>();
            while (rs.next()) {
                CarDTO searchCar = new CarDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getInt(10));
                listSearchCar.add(searchCar);
            }
            return listSearchCar;
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

    public int getMaxPriceOfCar() throws SQLException {
        try {
            String sql = "SELECT MAX(price) \n"
                    + "FROM Car \n"
                    + "WHERE quantity > 0 and status = 1  ";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int numMax = 0;
            if (rs.next()) {
                numMax = rs.getInt(1);
                return numMax;
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

    public CarDTO getCarById(int id) throws SQLException {
        try {
            String sql = "SELECT [carID]\n"
                    + "      ,[category_id]\n"
                    + "      ,[car_name]\n"
                    + "      ,[quantity]\n"
                    + "      ,[price]\n"
                    + "      ,[description]\n"
                    + "      ,[color]\n"
                    + "      ,[image]\n"
                    + "      ,[create_date]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[Car]\n"
                    + "  WHERE [carID] = ? AND [status] =1 AND [quantity] > 0";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                CarDTO car = new CarDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getInt(10));
                return car;
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

    public int updateAmountCar(CarDTO car) throws SQLException {
        try {
            String sql = "UPDATE [dbo].[Car]\n"
                    + "   SET\n"
                    + "      [quantity] = ?\n"
                    + "      \n"
                    + " WHERE Car.carID = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, car.getQuantity());
            ps.setInt(2, car.getCarId());
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

    public ArrayList<CarDTO> getAllCarAdmin() throws SQLException {
        try {
            String sql = "SELECT [carID]\n"
                    + "      ,[category_id]\n"
                    + "      ,[car_name]\n"
                    + "      ,[quantity]\n"
                    + "      ,[price]\n"
                    + "      ,[description]\n"
                    + "      ,[color]\n"
                    + "      ,[image]\n"
                    + "      ,[create_date]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[Car]";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<CarDTO> listCar = new ArrayList<>();
            while (rs.next()) {
                CarDTO car = new CarDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getInt(10));
                listCar.add(car);
            }
            return listCar;
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

    public int addNewCar(CarDTO car) throws SQLException {
        try {
            String sql = "INSERT INTO [dbo].[Car]\n"
                    + "           ([category_id]\n"
                    + "           ,[car_name]\n"
                    + "           ,[quantity]\n"
                    + "           ,[price]\n"
                    + "           ,[description]\n"
                    + "           ,[color]\n"
                    + "           ,[image]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,1)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, car.getCategory_id());
            ps.setString(2, car.getCar_name());
            ps.setInt(3, car.getQuantity());
            ps.setDouble(4, car.getPrice());
            ps.setString(5, car.getDescription());
            ps.setString(6, car.getColor());
            ps.setString(7, car.getImage());

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

    public CarDTO getCarByIdAdmin(int id) throws SQLException {
        try {
            String sql = "SELECT [carID]\n"
                    + "      ,[category_id]\n"
                    + "      ,[car_name]\n"
                    + "      ,[quantity]\n"
                    + "      ,[price]\n"
                    + "      ,[description]\n"
                    + "      ,[color]\n"
                    + "      ,[image]\n"
                    + "      ,[create_date]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[Car]\n"
                    + "  WHERE [carID] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                CarDTO car = new CarDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getInt(10));
                return car;
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

    public int updateStatusCar(int carId) throws SQLException {
        try {
            String sql = "UPDATE [dbo].[Car]\n"
                    + "   SET \n"
                    + "      [status] = 0\n"
                    + " WHERE carID = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, carId);

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

    public int updateCarById(CarDTO car, int carId) throws SQLException {
        try {
            String sql = "UPDATE [dbo].[Car]\n"
                    + "   SET [category_id] = ?\n"
                    + "      ,[car_name] = ?\n"
                    + "      ,[quantity] = ?\n"
                    + "      ,[price] = ?\n"
                    + "      ,[description] = ?\n"
                    + "      ,[color] = ?\n"
                    + "      ,[image] = ?\n"
                    + "      ,[status] = ?\n"
                    + " WHERE carID =?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, car.getCategory_id());
            ps.setString(2, car.getCar_name());
            ps.setInt(3, car.getQuantity());
            ps.setDouble(4, car.getPrice());
            ps.setString(5, car.getDescription());
            ps.setString(6, car.getColor());
            ps.setString(7, car.getImage());
            ps.setInt(8, car.getStatus());
            ps.setInt(9, carId);

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
