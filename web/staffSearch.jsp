<%-- 
    Document   : saerch
    Created on : Dec 8, 2018, 4:00:49 PM
    Author     : Lonaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Search</title>
    </head>
    <body>
        <s:if test="%{#session.USERR != null}">
            Welcome, 
            <font color="red"><s:property value="%{#session.USERR.fullName}"/></font><br/>
        </s:if>
        <s:a href="logout">Logout</s:a>
            <h1>Staff Search Page</h1>
        <s:form action="searchByStaff">
            <s:textfield name="keyword" label="Keyword"/>
            <s:submit value="Search"/>
        </s:form>

        <s:if test="%{keyword != null && !keyword.isEmpty()}">
            <s:if test="searchResult != null">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Food ID</th>
                            <th>Food Name</th>
                            <th>Price</th>
                            <th>Type</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="searchResult" status="counter">
                            <s:form action="update" method="GET" theme="simple">
                                <tr>
                                    <td>
                                        <s:property value="%{#counter.count}"/>
                                        .</td>
                                    <td>
                                        <s:property value="foodID"/>
                                        <s:hidden name="foodID" value="%{foodID}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="foodName" value="%{foodName}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="price" value="%{price}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="type" value="%{type}"/>
                                    </td>
                                    <td>
                                        <s:url id="delLink" action="delete">
                                            <s:param name="delFoodID" value="foodID"/>
                                            <s:param name="lastSearchValue" value="%{keyword}"/>
                                        </s:url>
                                        <s:a href="%{delLink}">Delete</s:a>
                                    </td>
                                    <td>
                                        <s:hidden name="lastSearchValue" value="%{keyword}"/>
                                        <s:submit value="Update"/>
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>
            <s:else><h2>No food found!</h2></s:else>
        </s:if>
        <s:a href="linkAddNewFood">Click here to add new food</s:a>
    </body>
</html>
