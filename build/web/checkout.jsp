<%-- 
    Document   : checkout
    Created on : Dec 12, 2018, 3:00:44 PM
    Author     : Lonaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
    </head>
    <body>
        <s:if test="%{#session.USERR != null}">
            Welcome,
            <font color="red"><s:property value="%{#session.USERR.fullName}"/></font><br/>
            <s:a href="logout">Logout</s:a>
        </s:if>
        <h1>Finishing Your Order</h1>
        <s:if test="%{#session.CART != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Food Name</th>
                        <th>Type</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="%{#session.CART.products}" status="counter">
                        <tr>
                            <td>
                                <s:property value="%{#counter.count}"/>
                                .</td>
                            <td>
                                <s:property value="%{key.productName}"/>
                            </td>
                            <td>
                                <s:property value="%{key.type}"/>
                            </td>
                            <td>
                                <s:property value="%{value}"/>
                            </td>
                            <td>
                                <s:property value="%{key.price}"/>
                            </td>
                            <td>
                                <s:property value="%{key.price * value}"/>
                            </td>
                        </tr>
                    </s:iterator>
                    <tr>
                        <td colspan="5"><p style="text-align: right">TOTAL</p></td>
                        <td>
                            <s:property value="%{#session.CART.getTotal()}"/>
                        </td>
                    </tr>
                </tbody>
            </table>

            <h2>Customer Information</h2>
            <s:form action="confirmBuying">
                <table border="0" style="border-bottom: 1px">
                    <tbody>
                        <tr>
                            <td>
                                <s:textfield name="orderID" value="%{#session.CART.orderID}" readonly="true" label="OrderID"/>
                            </td>
                            <td id="date"></td>
                            <s:hidden id="dateOrder" name="orderDate"/>
                            <script>
                                var d = new Date();
                                document.getElementById("date").innerHTML = "Date: " + d.toLocaleDateString();
                                document.getElementById("dateOrder").value = d.toLocaleDateString();
                            </script>
                            <td>
                                <s:if test="%{#session.USERR != null}">
                                    <s:textfield name="confirmFullName" value="%{#session.USERR.fullName}" readonly="true" label="Customer"/>
                                </s:if>
                                <s:else>
                                    <s:textfield name="confirmFullName" label="Customer"/>
                                </s:else>
                            </td>
                            <td>
                                <s:if test="%{#session.USERR != null}">
                                    <s:textfield name="confirmPhone" value="%{#session.USERR.phone}" readonly="true" label="Phone"/>
                                </s:if>
                                <s:else>
                                    <s:textfield name="confirmPhone" label="Phone"/>
                                </s:else>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <s:if test="%{#session.USERR != null}">
                                    <s:textfield name="confirmAddress" value="%{#session.USERR.address}" readonly="true" label="Address"/>
                                </s:if>
                                <s:else>
                                    <s:textfield name="confirmAddress" label="Address"/>
                                </s:else>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <s:textfield name="confirmReceiver" label="Receiver"/>
                            </td>
                            <td>
                                <s:textfield name="confirmReceiverPhone" label="Receiver's Phone"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <s:submit value="Confirm"/>
            </s:form>
            <s:a href="backToCart">
                <input type="button" value="Back" />
            </s:a>
            <s:a href="exitCheckout">
                <input type="button" value="Exit"/>
            </s:a>
        </s:if>
    </body>
</html>
