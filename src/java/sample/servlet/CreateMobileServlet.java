/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.mobile.MobileDAO;
import sample.mobile.MobileInsertError;
import sample.utils.Validate;

/**
 *
 * @author Mai Linh
 */
@WebServlet(name = "CreateMobileServlet", urlPatterns = {"/CreateMobileServlet"})
public class CreateMobileServlet extends HttpServlet {

    private final String insertErrorPage = "createNewMobile.jsp";
    private final String staffPage = "staffPage.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("txtMobileId");
        String description = request.getParameter("txtDescription");
        String txtPrice = request.getParameter("txtPrice");
        float price = 0;

        String name = request.getParameter("txtMobileName");
        String year = request.getParameter("cboYear");
        String quantity = request.getParameter("txtQuantity");
        String notSale = request.getParameter("chkNotSale");
        boolean notSale1 = false;
        if (notSale != null) {
            notSale1 = true;
        } else {
            notSale1 = false;
        }

        String url = insertErrorPage;
        MobileInsertError errors = new MobileInsertError();
        boolean bErr = false;
        Validate validate = new Validate();
        try {
            if (id.trim().length() != 4) {
                bErr = true;
                errors.setIdLengthErr("ID length must equal 4 chars");
            }
            if (description.trim().length() < 4 || description.trim().length() > 30) {
                bErr = true;
                errors.setIdLengthErr("description length requires 4 - 30 chars");
            }
            if (!quantity.matches("\\d") || quantity.trim().length() < 3 || quantity.trim().length() > 6) {
                bErr = true;
                errors.setIdLengthErr("quantity length requires 3 - 6 numbers");
            }
            if (name.trim().length() < 3 || name.trim().length() > 20) {
                bErr = true;
                errors.setIdLengthErr("name length requires 3 - 20 chars");
            }
            if (!txtPrice.matches("\\d")) {
                price = Float.parseFloat(txtPrice);
                bErr = true;
                errors.setIdLengthErr("you must enter digit numbers");
            }
            if (bErr) {
                //đưa lỗi về cho client
                //kiểu request scope
                request.setAttribute("INSERTERR", errors);
            } else {
                MobileDAO dao = new MobileDAO();
                boolean result = dao.insertRecord(id, price, description, Integer.parseInt(quantity), notSale1, Integer.parseInt(year), name);

                if (result) {
                    url = staffPage;
                }
            }
        } catch (SQLException ex) {
            log("CreateMobileServlet  _  Naming " + ex.getMessage());
            if (ex.getMessage().contains("duplicate")) {
                errors.setIdIsExisted(id + "is Existed in System!");
            }
        } catch (NamingException ex) {
            log("CreateMobileServlet  _  SQL " + ex.getMessage());

            request.setAttribute("INSERTERR", errors);//cap nhat Attribute
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
