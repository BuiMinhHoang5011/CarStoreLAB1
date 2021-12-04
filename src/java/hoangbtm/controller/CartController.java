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
import java.io.PrintWriter;
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
public class CartController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            ArrayList<CartDTO> listCart = (ArrayList<CartDTO>) session.getAttribute("listCart");

            //test
            ArrayList<CarDTO> listCar = new CarDAO().getAllCar();

            if (listCart == null) { // gio hang trong
                listCart = new ArrayList<>();
            }
            for (CartDTO cart : listCart) {
                for (CarDTO car : listCar) {
                    if (cart.getCarId() == car.getCarId()) {
                        if (cart.getQuantity() > car.getQuantity()) {
                            request.setAttribute("checkAmount", "Error");
                        }
                    }
                }
            }

            //end test
            double total = 0;
//            for (CartDTO cart : listCart) {
//                total += cart.getBookPrice() * cart.getQuantity();
//            }
            String totalTmp = request.getParameter("total");
            String checkDiscount = request.getParameter("checkDiscount");
            // System.out.println(checkDiscount);
            if (checkDiscount == null) {
                for (CartDTO cart : listCart) {
                    //System.out.println(cart.getTotalPrice());
                    total += cart.getCarPrice() * cart.getQuantity();
                }
            }else{
               total = Double.parseDouble(totalTmp);
            }
            request.setAttribute("total", total);
            request.setAttribute("listCart", listCart);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
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
