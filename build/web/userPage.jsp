<%-- 
    Document   : userPage
    Created on : Oct 15, 2018, 5:06:26 PM
    Author     : Mai Linh
--%>

<%@page import="java.util.List"%>
<%@page import="sample.mobile.MobileDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body>

    </body>
</html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile</title>
    </head>
    <body>
        <font color="red">
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String username = "";
                for (Cookie cookie : cookies) {
                    String temp = cookie.getName();
                    if (!temp.equals("JSESSIONID")) {
                        username = temp;
                    }
                }
                // khi nhấn F5 sẽ sinh ra một session giả

        %>
        Welcome, <%= username%>
        <%
            }//end cookie
        %>
        </font>
        <h1>Mobile Shop</h1>
        <form action="OrderServlet">
            Price from: <input type="text" name="txtMin" value="" /> to: <input type="text" name="txtMax" value="" />
            <input type="submit" value="Search Mobile" name="btAction" /><br/>
        <input type="submit" value="View Your Cart" name="btAction" /><br/>
        </form>
        <%
            String min = request.getParameter("txtMin");
            String max = request.getParameter("txtMax");
            if (min != null && max != null) {
                List<MobileDTO> result = (List<MobileDTO>) request.getAttribute("MOBILERESULT");
                if (result != null) {
        %> 

        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>ID</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Name</th>
                    <th>Year Of Product</th>
                    <th>Quantity</th>
                    <th>Not Sale</th>
                    <th>Buy Mobile</th>

                </tr>
            </thead>
            <tbody>
                <%                int count = 0;
                    for (MobileDTO dto : result) {

                %>
            <form action="OrderServlet">
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <%= dto.getMobileId()%>
                    </td>
                    <td>

                        <%= dto.getDescription()%>
                    </td>
                    <td>
                        <%= dto.getPrice()%>
                    </td>
                    <td>
                        <%= dto.getMobileName()%>
                    </td>
                    <td>
                        <%= dto.getYearOfProduction()%>
                    </td>
                    <td>
                        <%=dto.getQuantity()%>

                    </td>
                    <td>
                        <%=dto.isNotSale()%>

                    </td>
                    <td>
                        <input type="hidden" name="lastServletMin" value="<%=min %>" />
                        <input type="hidden" name="lastServletMax" value="<%=max %>" />
                        <input type="hidden" name="nameMobile" value="<%= dto.getMobileName()%>" />
                        <input type="submit" value="Add Mobile To Your Cart" name="btAction" />
                        
                    </td>

                </tr>
                <br/>

            </form>
            
            <%
                }
            %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <h2>
        No record is matched !!
    </h2>
    <%
            }
        }
    %>
    <br/>
   
</body>
</html>
