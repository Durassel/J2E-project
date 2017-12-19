<%@page import="jeeProjectVersion2.Member"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.lang.String"%>
<%@page import="jeeProjectVersion2.User"%>
<%@page import="jeeProjectVersion2.DBTransac"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${connected == null }">
    <c:redirect url = "Controller"/>
</c:if>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="default.css">
        <title>Members list</title>
    </head>
    <body>
        <h1>List of Members of the Java EE - M1 Club</h1>
        <form method="POST" action="Controller">
            <%  DBTransac dbTransac = new DBTransac();
                request.setAttribute("members", dbTransac.getMembers()); %>
            
            <c:if test="${members.size()==0}">
                <p style="color: blue">The club has no member !</p>
                <input type="submit" value="add" name="submit" />
            </c:if>

            <c:if test="${members.size()>0}">
                <table>
                    <thead>
                        <td>Sel</td>
                        <td>Firstname</td>
                        <td>Lastname</td>
                        <td>Email</td>
                    </thead>
                <c:forEach items="${members}" var="member">
                        <tr>
                             <td><input type="radio" name="selectMember" value="${member.id}" 
                                        <c:if test="${member.id == 1}">
                                             checked="checked"
                                        </c:if>
                            />
                             </td>
                            <td>${member.firstname}</td>
                            <td>${member.lastname}</td>
                            <td>${member.email}</td>
                        </tr>
                </c:forEach>
                </table>

                <input type="submit" value="details" name="submit" />
                <input type="submit" value="delete" name="submit" />
                <input type="submit" value="add" name="submit" />
            </c:if>
        </form>
    </body>
</html>
