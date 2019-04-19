<%-- 
    Document   : viewCart
    Created on : Dec 11, 2018, 4:15:44 PM
    Author     : Lonaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your cart</title>
    </head>
    <body>
        <s:if test="%{#session.USERR != null}">
            Welcome,
            <font color="red"><s:property value="%{#session.USERR.fullName}"/></font><br/>
            <s:a href="logout">Logout</s:a>
        </s:if>
        <h1>Your Cart's Items include</h1>
        <s:if test="%{#session.CART != null || !#session.CART.isEmpty()}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Food Name</th>
                        <th>Type</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <s:form action="removeCart" theme="simple">
                        <s:iterator value="%{#session.CART.products}" status="counter">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>
                                    .</td>
                                <td>
                                    <s:property value="key.productName"/>
                                </td>
                                <td>
                                    <s:property value="key.type"/>
                                </td>
                                <td>
                                    <s:property value="value"/>
                                </td>
                                <td>
                                    <s:property value="key.price"/>
                                </td>
                                <td>
                                    <s:checkbox name="selectedItem"
                                                fieldValue="%{key.productID}"/>
                                </td>
                            </tr>
                        </s:iterator>
                        <tr>
                            <td colspan="5">
                                <s:a href="addMore">Add more food to your Cart</s:a>
                                </td>
                                <td>
                                <s:submit value="Remove seleted items"/>
                            </td>
                        </tr>
                    </s:form>
                </tbody>
            </table>
            <s:a href="checkout">Checkout</s:a>
        </s:if>
        <s:if test="%{#session.CART == null}">
            <h2>Your cart is empty!!!</h2><br/>
            Click <s:a href="customerSearch.jsp">here</s:a> to add some food to your Cart
        </s:if>
    </body>
</html>
