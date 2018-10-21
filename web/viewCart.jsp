<%-- 
    Document   : viewCart
    Created on : Oct 13, 2018, 2:10:55 PM
    Author     : Mai Linh
--%>

<%@page import="java.util.Map"%>
<%@page import="sample.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile Store</title>
    </head>
    <body>
        <font color="red">
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String username = null;
                for (Cookie cookie : cookies) {
                    String temp = cookie.getName();
                    if (!cookie.getName().equals("JSESSIONID")) {
                        username = temp;
                    }
                }
        %>
        Welcome, <%= username%>
        <%
            }

        %>
        </font>
        <h1>Your Cart includes</h1>

        <%            if (session != null) {// luon kiem tra gio hang co hay ko
                CartObj cart = (CartObj) session.getAttribute("CART");

                if (cart != null) {
//cart trong Attribute la con tro dang tro vung nho CartObj
                    if (cart.getItems() != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Title</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <form action="OrderServlet">

                <%
                    Map<String, Integer> items = cart.getItems();
                    int count = 0;
                    for (Map.Entry item : items.entrySet()) {
                %>
                <tr>
                    <td>
                        <%= ++count%>
                        .</td>
                    <td>
                        <%= item.getKey()%>
                    </td>
                    <td>
                        <%= item.getValue()%>
                    </td>
                    <td>
                        <input type="checkbox" name="chkItem" value="<%= item.getKey()%>" />
                    </td>
                </tr>
                <%
                    }
                %> 
                <tr>
                    <td colspan="3">
                        <a href="userPage.jsp">Add More Items to Your Cart</a>                     </td>

                    <td><input type="submit" value="Remove Selected Items" name="btAction" /> </td>
                </tr><br/>
               
            </form>
        </tbody>
    </table>

    <%
                    return;
                }
            }//end cart
        }//end of session

    %>
    <h2>No cart is existed!!!</h2>

</body>
</html>
