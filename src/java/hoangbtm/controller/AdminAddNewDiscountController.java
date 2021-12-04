/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.controller;

import hoangbtm.dao.DiscountDAO;
import hoangbtm.dto.DiscountDTO;
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
public class AdminAddNewDiscountController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("AddNewDiscount.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String discountName = request.getParameter("discountName");
            double percent = Double.parseDouble(request.getParameter("percent"));
            DiscountDTO discount = new DiscountDAO().checkDuplicateDiscount(discountName);
            if (discount == null) {
                int checkAddDiscount = new DiscountDAO().AddNewDiscount(discountName, percent);
                if (checkAddDiscount != 0) {
                    request.setAttribute("success", "DONE !!");
                    request.getRequestDispatcher("AddNewDiscount.jsp").forward(request, response);
                } else {
                    request.setAttribute("err", "Add Discount Failed !!");
                    request.getRequestDispatcher("AddNewDiscount.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Discount Name Has Existed In Your Systems !!");
                request.getRequestDispatcher("AddNewDiscount.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminAddNewDiscountController.class.getName()).log(Level.SEVERE, null, ex);
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
