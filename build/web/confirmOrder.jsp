<%-- 
    Document   : confirmOrder
    Created on : Dec 12, 2018, 4:53:26 PM
    Author     : Lonaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Order</title>
    </head>
    <body>
        <s:if test="%{#session.USERR != null}">
            Welcome,
            <font color="red"><s:property value="%{#session.USERR.fullName}"/></font><br/>
            <s:a href="logout">Logout</s:a>
        </s:if>
        <h1>Confirm</h1>
        <h2>Your Information</h2>
        <table border="1" style="border-style: hidden;">
            <tbody>
                <tr>
                    <td>Customer ID: </td>
                    <td style="width: 400px">
                        <s:if test="%{#session.USERR != null}">
                            <s:property value="%{#session.USERR.username}"/>
                        </s:if>
                        <s:else>
                            <s:property value="guest"/>
                        </s:else>
                    </td>
                    <td>OrderID: </td>
                    <td>
                        <s:property value="%{#session.ORDERR.orderID}"/>
                    </td>
                </tr>
                <tr>
                    <td>Customer: </td>
                    <td>
                        <s:property value="%{#session.ORDERR.customer}"/>
                    </td>

                    <td>Phone: </td>
                    <td>
                        <s:property value="%{#session.ORDERR.phone}"/>
                    </td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td>
                        <s:property value="%{#session.ORDERR.address}"/>
                    </td>
                </tr>
                <tr>
                    <td>Receiver: </td>
                    <td>
                        <s:property value="%{#session.ORDERR.receiver}"/>
                    </td>
                    <td>Receiver's Phone: </td>
                    <td>
                        <s:property value="%{#session.ORDERR.receiverPhone}"/>
                    </td>
                </tr>
            </tbody>
        </table>
        <s:a href="finishBuying">
            <input type="submit" value="OK" />
        </s:a>
        <s:a href="cancelFinishBuying">
            <input type="button" value="Cancel" />
        </s:a>
    </body>
</html>
