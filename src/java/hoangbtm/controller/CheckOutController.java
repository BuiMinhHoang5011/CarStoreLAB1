/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.controller;

import hoangbtm.dao.CarDAO;
import hoangbtm.dao.DiscountCheckDAO;
import hoangbtm.dao.DiscountDAO;
import hoangbtm.dao.OrderCarDAO;
import hoangbtm.dao.OrderCarDetailDAO;
import hoangbtm.dao.ShipingDAO;
import hoangbtm.dto.AccountDTO;
import hoangbtm.dto.CarDTO;
import hoangbtm.dto.CartDTO;
import hoangbtm.dto.OrderCarDTO;
import hoangbtm.dto.ShippingDTO;
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
public class CheckOutController extends HttpServlet {

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
            out.println("<title>Servlet CheckOutController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        ArrayList<CartDTO> listCart = (ArrayList<CartDTO>) session.getAttribute("listCart");
        String totalTmp = request.getParameter("total");
        String discount = request.getParameter("discount");
        double total = 0;
        if (totalTmp != null) {
            total = Double.parseDouble(totalTmp);
        } else {
            for (CartDTO cart : listCart) {
                total += cart.getCarPrice() * cart.getQuantity();
            }
        }
        request.setAttribute("discount", discount);
        request.setAttribute("total", total);
        request.getRequestDispatcher("Checkout.jsp").forward(request, response);
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
        try {
            String discount = request.getParameter("discount");
            //System.out.println(discount);
            String name = request.getParameter("name");
            String moblie = request.getParameter("mobile");
            String address = request.getParameter("address");
            String note = request.getParameter("note");

            HttpSession session = request.getSession();
            AccountDTO account = (AccountDTO) session.getAttribute("account");

            //String username = account.getUserName();
            int userId = account.getUserId();

            ShippingDTO shipping = new ShippingDTO(name, moblie, address, note);

            //luu bang shipping vao DB
            int shipId = new ShipingDAO().addShippingReturnId(shipping);
            if (shipId != 0) {
                ArrayList<CartDTO> listCart = (ArrayList<CartDTO>) session.getAttribute("listCart");
                String totalTmp = request.getParameter("total");
                double totalPrice = 0;
                if (totalTmp != null) {
                    totalPrice = Double.parseDouble(totalTmp);
                } else {
                    for (CartDTO cart : listCart) {
                        totalPrice += cart.getCarPrice() * cart.getQuantity();
                    }
                }

                OrderCarDTO order = new OrderCarDTO();
                order.setAccountId(userId);
                order.setShipping_id(shipId);
                order.setTotalPrice(totalPrice);
                int discountId = new DiscountDAO().getDiscountIdByName(discount);
                if (discountId == 0) {
                    order.setDiscount(null);
                } else {
                    order.setDiscount(String.valueOf(discountId));
                    int checkAddDiscountCheck = new DiscountCheckDAO().addDiscountCheck(discountId, account.getUserId());
                    if(checkAddDiscountCheck == 0){
                        response.sendRedirect("wrong");
                    }
                }                

                // them order vao DB
                int orderId = new OrderCarDAO().addOrderReturnId(order);
                if (orderId != 0) {

                    //them orderDetail vao DB
                    int checkOrderDetail = new OrderCarDetailDAO().addOrderDetailReturnId(listCart, orderId);
                    if (checkOrderDetail != 0) {
                        // update lai so luong sach
                        ArrayList<CarDTO> listCar = new CarDAO().getAllCar();
                        int checkUpdateCar = 0;
                        for (CarDTO car : listCar) {
                            for (CartDTO cart : listCart) {
                                if (car.getCarId() == cart.getCarId()) {
                                    car.setQuantity(car.getQuantity() - cart.getQuantity());
                                    checkUpdateCar = new CarDAO().updateAmountCar(car);
                                }
                            }
                        }
                        if (checkUpdateCar != 0) {
                            session.removeAttribute("listCart");
                            response.sendRedirect("thank");
                        }
                    } else { //them orderDetail fail
                        //1. remove order by orderId
                        //2. remove shipping by shipping Id
                        response.sendRedirect("wrong");
                    }
                } else { //them order fail
                    // remove shipping by Id
                    response.sendRedirect("wrong");
                }
            } else {
                response.sendRedirect("wrong"); //  show error 
            }

        } catch (SQLException ex) {
            Logger.getLogger(CheckOutController.class.getName()).log(Level.SEVERE, null, ex);
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
