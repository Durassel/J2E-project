<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  String connected = (String) session.getAttribute("connected");
    if (connected != null) {
        response.sendRedirect("members.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>EFREI - Java EE - M1</h1>
         <c:if test="${!empty error}">
            <span style="color:red">  ${error} </span>
        </c:if>
        <form method='post' action='Controller'>
            <label>Enter your credentials</label>
                <Table>
                    <tr>
                <th>
                    <label>Login</label>
                </th>
                <td>
                    <input type='text' name='login' value='' />
                </td>
                </tr>
                <tr>
                    <th>
                        <label>Password</label>
                    </th>
                    <td>
                        <input type="password" name="password" value="" />
                    </td>
                </tr>
            </Table>
            <input type="submit" value="Sign in" name ="signIn"/>
        </form>
    </body>
</html>


