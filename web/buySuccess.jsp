<%-- 
    Document   : buySuccess
    Created on : Dec 13, 2018, 4:58:22 PM
    Author     : Lonaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notification</title>
    </head>
    <body>
        <s:if test="%{#session.USERR != null}">
            Hi,
            <font color="red"><s:property value="%{#session.USERR.fullName}"/></font><br/>
            <s:a href="logout">Logout</s:a>
        </s:if>
        <h1>You book the food successfull!!!</h1>
        <a href="backHomeCustomer">Click here to come back home page</a>
    </body>
</html>
