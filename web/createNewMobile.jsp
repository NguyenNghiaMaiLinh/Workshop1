<%-- 
    Document   : createNewMobile
    Created on : Oct 13, 2018, 10:54:32 PM
    Author     : Mai Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Mobile</title>
    </head>
    <body>
        <h1>Create New Mobile</h1>
        <form action="OrderServlet" method="POST">
            ID* <input type="text" name="txtMobileId" value="" />(4 chars)<br/>
            Description* <input type="text" name="txtDescription" value="" />(4 - 30 chars)<br/>
            Price* <input type="text" name="txtPrice" value="" />(3 - 6 numbers)<br/>
            Name* <input type="text" name="txtMobileName" value="" />(3 -20 chars)<br/>
            Year* <select name="cboYear"><br/>
                <option>2010</option>
                <option>2011</option>
                <option>2012</option>
                <option>2013</option>
                <option>2014</option>
                <option>2015</option>
                <option>2016</option>
            </select>
            Quantity* <input type="checkbox" name="chkNotSale" value="" />
            <input type="submit" value="Create New Mobile" name="btAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
