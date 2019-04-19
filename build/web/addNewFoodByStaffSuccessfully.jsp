<%-- 
    Document   : addNewFoodByStaffSuccessfully
    Created on : Dec 16, 2018, 11:29:13 PM
    Author     : Lonaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body>
        <s:if test="%{#session.USERR != null}">
            Welcome, 
            <font color="red"><s:property value="%{#session.USER.fullName}"/></font><br/>
            <s:a href="logout">Logout</s:a>
        </s:if>
            <h2>Add new food successfully!!!</h2>
            Click <s:a href="staffSearch.jsp">here</s:a> to come back to Search page
    </body>
</html>
