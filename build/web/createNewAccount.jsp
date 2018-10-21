<%-- 
    Document   : createNewAccount
    Created on : Oct 13, 2018, 4:16:38 PM
    Author     : Mai Linh
--%>

<%@page import="sample.registration.RegistrationInsertError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Account</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="OrderServlet" method="POST">
            Username* <input type="text" name="txtUsername" value="<%= request.getParameter("txtUsername")%>" />(6 - 20 chars)<br/>
            <font color="red">
            <%
                //kiểu dữ liệu là RegistrationInsertError
                RegistrationInsertError errors
                        = (RegistrationInsertError) request.getAttribute("INSERTERR");
                if (errors != null) {
                    if (errors.getUsernameLengthErr() != null) {
            %>
            <%= errors.getFullNameLengthErr()%>    
            <%
                    }
                }
            %>
            </font>
            <br/>
            Password* <input type="password" name="txtPassword" value="" />(6 - 30 chars)<br/>
            <% if (errors != null) {
                    if (errors.getFullNameLengthErr() != null) {
            %>
            <%= errors.getPasswordLengthErr()%>    
            <%
                    }
                }
            %>
            <br/>
            Confirm* <input type="password" name="txtConfirm" value="" /><br/>
            <% if (errors != null) {
                    if (errors.getComfirmNotMatch() != null) {
            %>
            <%= errors.getComfirmNotMatch()%>    
            <%
                    }
                }
            %>
            <br/>
            Full name* <input type="text" name="txtFullname" value="<%= request.getParameter("txtFullname")%>" />(2 - 50 chars)<br/>
            <% if (errors != null) {
                    if (errors.getFullNameLengthErr() != null) {
            %>
            <%= errors.getFullNameLengthErr()%>    
            <%
                    }
                }
            %>
            <br/>
            <input type="submit" value="Create New Account" name="btAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
