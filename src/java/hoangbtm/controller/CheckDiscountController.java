/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.controller;

import hoangbtm.dao.CarDAO;
import hoangbtm.dao.DiscountCheckDAO;
import hoangbtm.dao.DiscountDAO;
import hoangbtm.dto.AccountDTO;
import hoangbtm.dto.CarDTO;
import hoangbtm.dto.CartDTO;
import hoangbtm.dto.DiscountCheckDTO;
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
public class CheckDiscountController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckDiscountController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckDiscountController at " + request.getContextPath() + "</h1>");
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
            AccountDTO account = (AccountDTO) session.getAttribute("account");
            String discount = request.getParameter("discount");
            //System.out.println(discount);
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
            total = Double.parseDouble(request.getParameter("total"));
            
            //System.out.println(request.getParameter("total"));
            
            ArrayList<DiscountCheckDTO> listDiscountCheck = new DiscountCheckDAO().getDiscountUsingByAccountId(account.getUserId());
            
            //System.out.println(listDiscountCheck);
            
            int discountId = new DiscountDAO().getDiscountIdByName(discount);
            boolean flag = false;
            for (DiscountCheckDTO check : listDiscountCheck) {
                if (check.getD_id() == discountId) {
                    request.setAttribute("errorDiscount", "Your account already using this discount");
                    request.setAttribute("discount", null);
                    flag = true;
                    //total = total;
                } else {
                    double percent = new DiscountDAO().getPercentByDiscountName(discount);
                    System.out.println(percent);
                    total = total - (total * percent / 100);
                    request.setAttribute("discount", discount);
                }
            }
            if (!flag) {
                double percent = new DiscountDAO().getPercentByDiscountName(discount);
                System.out.println(percent);
                total = total - (total * percent / 100);
                request.setAttribute("discount", discount);
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
