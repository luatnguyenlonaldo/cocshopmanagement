<%-- 
    Document   : login
    Created on : Dec 7, 2018, 4:55:48 PM
    Author     : Lonaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="login" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Username: </td>
                        <td>
                            <input type="text" name="username" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td>
                            <input type="password" name="password" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Login" />
                            <input type="reset" value="Reset" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        Click <a href="registerNewAccount.jsp">here</a> to register new account
    </body>
</html>
