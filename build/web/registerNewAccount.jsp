<%-- 
    Document   : registerNewAccount
    Created on : Dec 14, 2018, 11:09:46 AM
    Author     : Lonaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <s:head/>
    </head>
    <body>
        <h1>Your information</h1>
        <font color="blue">Please fill your information to all cell...</font>
        <s:form action="registerNewAccount">
            <table border="0">
                <tbody>
                    <tr>
                        <td>
                            <s:textfield name="username" label="Username"/>
                        </td>
                        <td>
                            <s:textfield name="password" label="Password"/>
                        </td>
                        <td>
                            <s:textfield name="confirmPassword" label="Confirm password"/> 
                        </td>
                        <td>
                            <s:textfield name="fullName" label="Full name"/>
                        </td>
                        <td>
                            <s:textfield name="address" label="Address"/>
                        </td>
                        <td>
                            <s:textfield name="phone" label="Phone number"/>
                        </td>
                    </tr>
                    <tr><s:submit value="Create"/></tr>
                </tbody>
            </table>
        </s:form>
        <s:if test="%{exception.message.indexOf('duplicate') > -1}">
            <font color="red">
            <s:property value="username"/> is existed!!!<br/>
            </font>
        </s:if>
            Click <s:a href="login.jsp">here</s:a> to login
    </body>
</html>
