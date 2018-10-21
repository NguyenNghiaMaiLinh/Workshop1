/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mai Linh
 */
public class OrderServlet extends HttpServlet {

    private final String loginPage = "login.html";
    private final String loginServlet = "LoginServlet";
    private final String searchServlet = "SearchServlet";
    private final String deleteServlet = "DeleteServlet";
    private final String updateServlet = "UpdateServlet";
    private final String nullServlet = "NullServlet";
    private final String addMobileServlet = "AddMobileServlet";
    private final String viewCartPage = "viewCart.jsp";
    private final String deleteItemServlet = "DeleteItemServlet";
    private final String createNewAccountServlet = "CreateAccountServlet";
    private final String createNewMobileServlet = "CreateMobileServlet";
    private final String logoutServlet = "LogoutServlet";
    private final String searchMobile = "SearchMobileServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String button = request.getParameter("btAction");
        String url = loginPage;
        try {
            if (button == null) {
                url = nullServlet;
            }
            if (button.equals("Login")) {
                url = loginServlet;
            }
            if (button.equals("Search")) {
                url = searchServlet;
            }
            if (button.equals("Delete")) {
                url = deleteServlet;
            }
            if (button.equals("Update")) {
                url = updateServlet;
            }
            if (button.equals("Add Mobile To Your Cart")) {
                url = addMobileServlet;
            }
            if (button.equals("View Your Cart")) {//trang dong do gio hang khac nhau
                //view chac chan la trang tinh hay dong
                url = viewCartPage;
            }
            if (button.equals("Remove Selected Items")) {
                url = deleteItemServlet;
            }
            if (button.equals("Create New Account")) {
                url = createNewAccountServlet;
            }
            if (button.equals("Create New Mobile")) {
                url = createNewMobileServlet;
            }
            if (button.equals("Logout")) {
                url = logoutServlet;
            }
            if (button.equals("Search Mobile")) {
                url = searchMobile;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
        processRequest(request, response);
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
