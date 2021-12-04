/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.controller;

import hoangbtm.dao.OrderCarDAO;
import hoangbtm.dto.OrderCarDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class SearchHistoryDateController extends HttpServlet {

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
            out.println("<title>Servlet SearchHistoryDateController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchHistoryDateController at " + request.getContextPath() + "</h1>");
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
            String fromTmp;
            String toTmp;
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            
            if(from.isEmpty() || from == null){
                fromTmp = "2021-05-10";
            }else{
                fromTmp = from;
            }
            if(to.isEmpty() || to == null){
                toTmp = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }else{
                toTmp = to;
            }
            System.out.println(fromTmp);
            System.out.println(toTmp);
            ArrayList<OrderCarDTO> listOrder = new OrderCarDAO().getAllOrderByDate(fromTmp, toTmp);
            
            request.setAttribute("listOrder", listOrder);
            request.getRequestDispatcher("searchHistoryDate.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchHistoryDateController.class.getName()).log(Level.SEVERE, null, ex);
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
