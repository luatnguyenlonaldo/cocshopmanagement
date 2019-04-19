<%-- 
    Document   : customerSearch
    Created on : Dec 10, 2018, 2:39:23 PM
    Author     : Lonaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="#session.USER == null">
    
</s:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Search</title>
    </head>
    <body>
        <s:if test="%{#session.USERR != null}">
            Welcome,
            <font color="red"><s:property value="%{#session.USERR.fullName}"/></font>
        </s:if><br/>
        <s:a href="logout">Logout</s:a>
            <h1>Customer Search</h1>
        <s:form action="searchByCustomer">
            <s:textfield name="keyword" label="Keyword"/>
            <s:submit value="Search"/>
        </s:form>

        <s:if test="%{keyword != null && !keyword.isEmpty()}">
            <s:if test="searchResult != null">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Food Name</th>
                            <th>Price</th>
                            <th>Price</th>
                            <th>Add to Cart</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="searchResult" status="counter">
                            <s:form action="addToCart" method="GET" theme="simple">
                                <tr>
                                    <td>
                                        <s:property value="%{#counter.count}"/>
                                        .</td>
                                    <td>
                                        <s:property value="foodName"/>
                                        <s:hidden name="foodID" value="%{foodID}"/>
                                        <s:hidden name="foodName" value="%{foodName}"/>
                                    </td>
                                    <td>
                                        <s:property value="price"/>
                                        <s:hidden name="price" value="%{price}"/>
                                    </td>
                                    <td>
                                        <s:property value="type"/>
                                        <s:hidden name="type" value="%{type}"/>
                                    </td>
                                    <td>
                                        <s:if test="%{status}">
                                            <s:hidden name="lastSearchValue" value="%{keyword}"/>
                                            <s:submit value="Add" title="Click here to add to Cart"/>
                                        </s:if>
                                        <s:else><p style="text-align: center">Updating</p></s:else>
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else><h2>No food found!</h2></s:else>
        </s:if>
        <s:a href="viewCart.jsp">Click here to view Cart</s:a>
    </body>
</html>
