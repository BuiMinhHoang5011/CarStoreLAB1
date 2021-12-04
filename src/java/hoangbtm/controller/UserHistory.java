/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.controller;

import hoangbtm.dao.DiscountDAO;
import hoangbtm.dao.OrderCarDAO;
import hoangbtm.dto.AccountDTO;
import hoangbtm.dto.DiscountDTO;
import hoangbtm.dto.OrderCarDTO;
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
public class UserHistory extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserHistory</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserHistory at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            AccountDTO account = (AccountDTO) session.getAttribute("account");
            int accountId = 0;
            if (account != null) {
                accountId = account.getUserId();
                ArrayList<OrderCarDTO> listOrder = new OrderCarDAO().getAllOrderByAccount(accountId);
                ArrayList<DiscountDTO> listDiscount = new DiscountDAO().getAllDiscount();
                
                request.setAttribute("listDiscount", listDiscount);
                request.setAttribute("listOrder", listOrder);
                request.getRequestDispatcher("UserHistory.jsp").forward(request, response);
            }else{
                response.sendRedirect("error-page");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserHistory.class.getName()).log(Level.SEVERE, null, ex);
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
