<%-- 
    Document   : details
    Created on : 5 déc. 2017, 15:27:00
    Author     : Administrateur
--%>

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
        <title>Details</title>
    </head>
    <body>
        <c:if test="${connected == null }">
             <c:redirect url = "Controller"/>
        </c:if>

        <%  DBTransac dbTransac = new DBTransac();
            request.setAttribute("member", dbTransac.getMemberById(Integer.parseInt(request.getParameter("selectMember")))); %>

        <c:if test="${member == null }">
            response.sendRedirect("members.jsp");
        </c:if>

        <h1>Member ${member.firstname} ${member.lastname}</h1>
        <form action="Controller" method="POST">
            <input type="hidden" name="id" value='${member.id}' />
            <label>Last name : </label><input type="text" name="lastname" value='${member.lastname}' />
            <label>First name : </label><input type="text" name="firstname" value='${member.firstname}' /><br>
            <br><label><b>Phone number</b></label><br>
            <label>Home : </label><input type="text" name="homeNumber" value='${member.homeNum}' /><br>
            <label>Mobile : </label><input type="text" name="mobileNumber" value='${member.mobileNum}' /><br>
            <label>Work : </label><input type="text" name="workNumber" value='${member.workNum}' /><br>
            <br>
            <label>Address : </label><input type="text" name="address" value='${member.address}' /><br>
            <label>Postal code : </label><input type="text" name="postalCode" value='${member.postalCode}' />
            <label>City : </label><input type="text" name="city" value='${member.city}' /><br>
            <label>E-mail : </label><input type="text" name="email" value='${member.email}' /><br>
            <input type="submit" value="Save" name="details" />
            <input type="submit" value="Cancel" name="details" />
        </form>
    </body>
</html>
