package hoangbtm.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AdminUpdateCarController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int carId = Integer.parseInt(request.getParameter("carId"));
            CarDTO car = new CarDAO().getCarByIdAdmin(carId);
            ArrayList<CategoryDTO> listCategory = new CategoryDAO().getAllCategory();

            request.setAttribute("carId", carId);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("car", car);
            request.getRequestDispatcher("UpdateCar.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUpdateCarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int carId = Integer.parseInt(request.getParameter("carId"));
            int categoryId = Integer.parseInt(request.getParameter("category"));
            String carname = request.getParameter("carname");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            String color = request.getParameter("color");
            String image = request.getParameter("image");
            int status = Integer.parseInt(request.getParameter("status"));

            CarDTO car = new CarDTO(categoryId, carname, quantity, price, description, color, image, status);

            if (image.endsWith(".jpg") || image.endsWith(".png")) {
                int checkUpdate = new CarDAO().updateCarById(car, carId);
                if (checkUpdate != 0) {
                    response.sendRedirect("list-car");
                } else {
                    request.setAttribute("err", "Error");
                    request.getRequestDispatcher("UpdateCar.jsp").forward(request, response);
                }
            } else {
                ArrayList<CategoryDTO> listCategory = new CategoryDAO().getAllCategory();
                
                request.setAttribute("errImg", "Input must end with .jpg or .png");
                request.setAttribute("carId", carId);
                request.setAttribute("listCategory", listCategory);
                request.setAttribute("car", car);
                request.getRequestDispatcher("UpdateCar.jsp").forward(request, response);
            }

            //System.out.println(request.getParameter("bookname"));
        } catch (SQLException ex) {
            Logger.getLogger(AdminUpdateCarController.class.getName()).log(Level.SEVERE, null, ex);
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
