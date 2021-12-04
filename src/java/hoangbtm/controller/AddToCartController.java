/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.controller;

import hoangbtm.dao.CarDAO;
import hoangbtm.dto.CarDTO;
import hoangbtm.dto.CartDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hoang
 */
public class AddToCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            
            int carId = Integer.parseInt(request.getParameter("carId"));
            CarDTO car = new CarDAO().getCarById(carId);
            
            CartDTO cart = new CartDTO(carId, car.getCar_name(), car.getImage(), car.getPrice(), car.getQuantity(), 1, car.getPrice());
            
            ArrayList<CartDTO> listCart = (ArrayList<CartDTO>) session.getAttribute("listCart");
            if(listCart == null){ // gio hang trong
                listCart = new ArrayList<>();
                listCart.add(cart);
            }else{ // gio hang dang co san pham
                boolean checkExist =false;
                for (CartDTO ca : listCart) {
                    if(ca.getCarId() == carId){ // dang ton tai san pham cung ten trong gio hang
                        ca.setQuantity(ca.getQuantity() + 1); // tang so luong san pham do len 1                       
                        checkExist = true;
                    }
                }if(!checkExist){ // trong gio hang chua co san pham cung ten
                    listCart.add(cart);
                }
            }
            session.setAttribute("listCart", listCart);  // cap nhat lai listCart
            response.sendRedirect("home");
        } catch (SQLException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
