/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.controller;

import hoangbtm.dao.CarDAO;
import hoangbtm.dao.CategoryDAO;
import hoangbtm.dto.CarDTO;
import hoangbtm.dto.CategoryDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoang
 */
public class AdminAddNewCarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<CategoryDTO> listCategory = new CategoryDAO().getAllCategory();

            request.setAttribute("listCategory", listCategory);
            request.getRequestDispatcher("AddNewCar.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminAddNewCarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int categoryId = Integer.parseInt(request.getParameter("category"));
            String name = request.getParameter("carname");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            String color = request.getParameter("color");
            String image = request.getParameter("image");

            CarDTO car = new CarDTO();
            car.setCategory_id(categoryId);
            car.setCar_name(name);
            car.setQuantity(quantity);
            car.setPrice(price);
            car.setDescription(description);
            car.setColor(color);
            car.setImage(image);
            int checkAdd = new CarDAO().addNewCar(car);

            if (checkAdd != 0) {
                response.sendRedirect("admin-home");
            } else {
                request.setAttribute("err", "Add Failed !! Please check again");
                request.getRequestDispatcher("AddNewCar.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminAddNewCarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
