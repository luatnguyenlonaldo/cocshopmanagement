<%-- 
    Document   : addNewFoodBySatff
    Created on : Dec 10, 2018, 4:24:19 PM
    Author     : Lonaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Food</title>
        <s:head/>
    </head>
    <body>
        <s:if test="%{#session != null}">
            Welcome,
            <font color="red"><s:property value="%{#session.USERR.fullName}"/></font><br/>
            <s:a href="logout">Logout</s:a>
        </s:if>
        <h1>Information of new food</h1>
        <s:form action="addNewFoodByStaff">
            <s:textfield name="foodID" label="Food ID"/>
            <s:textfield name="foodName" label="Food Name"/>
            <s:textfield name="price" label="Price"/>
            <s:textfield name="type" label="Type"/>
            <s:submit value="Create"/>
            <s:reset label="Reset"/>
        </s:form>
        <s:if test="%{exception.message.indexOf('duplicate') > -1}">
            <font color="red">
            <s:property value="foodID"/> is existed!!!<br/>
            </font>
        </s:if>
        Click <s:a href="staffSearch.jsp">here</s:a> to come back Search Page
    </body>
</html>
