<%-- 
    Document   : staffPage
    Created on : Oct 11, 2018, 4:27:02 PM
    Author     : Mai Linh
--%>

<%@page import="java.util.List"%>
<%@page import="sample.mobile.MobileDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
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
        <h1>Search Page</h1>
        <form action="OrderServlet">
            Search value <input type="text" name="txtSearchValue" value="" />
            <input type="submit" value="Search" name="btAction" />
            <input type="submit" value="Logout" name="btAction" />
            <br/>
            <a href="createNewMobile.html">Click here to New Mobile</a><br/>    
        </form>
        <%
            String searchValue = request.getParameter("txtSearchValue");
            if (searchValue != null) {
                List<MobileDTO> result = (List<MobileDTO>) request.getAttribute("SEARCHRESULT");
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
                    <th>Year Of Production</th>
                    <th>Quantity</th>
                    <th>Not Sale</th>
                    <th>Delete</th>
                    <th>Update</th>

                </tr>
            </thead>
            <tbody>
                <%                int count = 0;
                    for (MobileDTO dto : result) {
                        String urlRewriting = "OrderServlet?"
                                + "btAction=Delete"
                                + "&mobileId="
                                + dto.getMobileId()
                                + "&lastSearchValue="
                                + searchValue;
                %>
            <form action="OrderServlet">
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <input type="text" name="txtID" value="<%= dto.getMobileId()%>" />
                    </td>
                    <td>

                        <input type="text" name="txtDescription" value=" <%= dto.getDescription()%>" />
                    </td>
                    <td>
                        <input type="text" name="txtPrice" value="<%= dto.getPrice()%>" />
                    </td>
                    <td>
                        <%= dto.getMobileName()%>
                    </td>
                    <td>
                        <%= dto.getYearOfProduction()%>
                    </td>
                    <td>
                        <input type="text" name="txtQuantity" value="<%= dto.getQuantity()%>" />

                    </td>
                    <td>

                        <input type="checkbox" name="chkNotSale" value="SALE" 
                               <%
                                   if (dto.isNotSale()) {
                               %>
                               checked="checked"
                               <%
                                   }
                               %>
                               />
                    </td>
                    <td>

                        <a href="<%= urlRewriting%>">Delete</a>
                    </td>
                    <td>
                        <input type="hidden" name="lastSearchValue" value="<%= searchValue%>" />
                        <input type="submit" value="Update" name="btAction" />
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

</body>
</html>
