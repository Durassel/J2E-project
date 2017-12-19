<%@page import="jeeProjectVersion2.DBTransac"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.lang.String"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add</title>
    </head>
    <body>
        <c:if test="${connected == null }">
            <c:redirect url = "Controller"/>
        </c:if>

        <form action="Controller" method="POST">
            <label>Last name : </label><input type="text" name="lastname"/>
            <label>First name : </label><input type="text" name="firstname"/><br>
            <br><label><b>Phone number</b></label><br>
            <label>Home : </label><input type="text" name="homeNumber"/><br>
            <label>Mobile : </label><input type="text" name="mobileNumber"/><br>
            <label>Work : </label><input type="text" name="workNumber"/><br>
            <br>
            <label>Address : </label><input type="text" name="address"/><br>
            <label>Postal code : </label><input type="text" name="postalCode"/>
            <label>City : </label><input type="text" name="city"/><br>
            <label>E-mail : </label><input type="text" name="email"/><br>
            <input type="submit" value="Add" name="add" />
        </form>
    </body>
</html>
