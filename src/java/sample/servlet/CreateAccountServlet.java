/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.registration.RegistrationDAO;
import sample.registration.RegistrationInsertError;

/**
 *
 * @author Mai Linh
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    private final String insertErrorPage = "createNewAccount.jsp";
    private final String loginPage = "login.html";

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
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");

        String url = insertErrorPage;
        RegistrationInsertError errors = new RegistrationInsertError();
        boolean bErr = false;
        try {
            if (username.trim().length() < 6 || password.trim().length() > 20) {
                bErr = true;
                errors.setFullNameLengthErr("username length requires 6 - 20 chars");
            }
            if (!password.matches("\\d") || password.trim().length() < 6 || password.trim().length() > 30) {
                bErr = true;
                errors.setFullNameLengthErr("password length requires 6 - 30 numbers");
            } else if (!confirm.trim().equals(password.trim())) {
                bErr = true;
                errors.setComfirmNotMatch("confirm must match password");
            }
            if (fullname.trim().length() < 6 || fullname.trim().length() > 20) {
                bErr = true;
                errors.setFullNameLengthErr("full Name length requires 2 - 50 chars");
            }
            if (bErr) {
                //đưa lỗi về cho client
                //kiểu request scope
                request.setAttribute("INSERTERR", errors);
            } else {
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.insertRecord(username, Integer.parseInt(password), fullname, 0);
                if (result) {
                    url = loginPage;
                }
            }
            //lỗi System cần ghi nhận lại 
        } catch (SQLException ex) {
            log("CreateAccountServlet  _  Naming " + ex.getMessage());
            //khi trong message lỗi chứa duplicate
            if (ex.getMessage().contains("duplicate")) {
                errors.setUsernameIsExisted(username + "is Existed in System!");
            }
        } catch (NamingException ex) {
            log("CreateAccountServlet  _  SQL " + ex.getMessage());
//lỗi trong tay mình
            request.setAttribute("INSERTERR", errors);
        } finally {
            //ko dùng respone
            //vì mình dã dùng request Scope nên lỗi sẽ bị mất.
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
