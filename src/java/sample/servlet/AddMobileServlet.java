/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.cart.CartObj;

/**
 *
 * @author Mai Linh
 */
@WebServlet(name = "AddMobileServlet", urlPatterns = {"/AddMobileServlet"})
public class AddMobileServlet extends HttpServlet {

    private final String shoppingPage = "userPage.jsp";

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
        PrintWriter out = response.getWriter();
        String url = shoppingPage;
        String min = request.getParameter("lastServletMin");
        String max = request.getParameter("lastServletMax");
        try {
            //đến chổ lấy giỏ
            HttpSession session = request.getSession();//get true, chắc chắn khác null

            //Lấy cái giỏ
            CartObj cart = (CartObj) session.getAttribute("CART");
            if (cart == null) {//kiểm tra giỏ không
                cart = new CartObj();
            }
            // lấy hàng
            String title = request.getParameter("nameMobile");

            //bo hang vao trong gio
            cart.addItemToCart(title);

            //cap nhat gio tren session
            session.setAttribute("CART", cart);

            //di mua hang tiep
            url = "OrderServlet?btAction=Search+Mobile&txtMin="
                    + min + "&txtMax=" + max;
            response.sendRedirect(url);//cai gi cung dc
        } finally {
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
