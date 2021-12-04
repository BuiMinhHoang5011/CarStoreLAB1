/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.controller;

import hoangbtm.dao.CategoryDAO;
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
public class AdminAddNewCategoryController extends HttpServlet {

    
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
            request.getRequestDispatcher("AddNewCategory.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminAddNewCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String categoryName = request.getParameter("category");
            CategoryDAO dao = new CategoryDAO();
            CategoryDTO category = dao.checkDuplicateName(categoryName);
            if (category == null) {
                int checkAddCategory = dao.addCategory(categoryName);
                if (checkAddCategory != 0) {
                    ArrayList<CategoryDTO> listCategory = new CategoryDAO().getAllCategory();

                    request.setAttribute("success", "Add New Done !!");
                    request.setAttribute("listCategory", listCategory);
                    request.getRequestDispatcher("AddNewCategory.jsp").forward(request, response);
                } else {
                    ArrayList<CategoryDTO> listCategory = new CategoryDAO().getAllCategory();

                    request.setAttribute("error", "Add New Failed");
                    request.setAttribute("listCategory", listCategory);
                    request.getRequestDispatcher("AddNewCategory.jsp").forward(request, response);
                }
            } else {
                ArrayList<CategoryDTO> listCategory = new CategoryDAO().getAllCategory();

                request.setAttribute("err", "Name Of This Category Has Existed In System");
                request.setAttribute("listCategory", listCategory);
                request.getRequestDispatcher("AddNewCategory.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminAddNewCategoryController.class.getName()).log(Level.SEVERE, null, ex);
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
