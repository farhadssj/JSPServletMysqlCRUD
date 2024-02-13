<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>

<!doctype html>
<html lang="en">
<head>
    <title>Expense Manager</title>
    <link rel="stylesheet" type="text/css" href="style/style.css?version=3">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" />
</head>
<body>
<%@ include file="header.jsp" %>
<%
List<String[]> expenseList = (List<String[]>) request.getAttribute("expenseList");
%>
<div class="container" style="max-width: 900px;">
    <h2>Your Spending</h2>
    <input type="button" value="Add Expense" onclick="location.href='addExpense'" style="display: block;width: fit-content;float: right;margin-bottom: 5px;">
    <table id="customers">
        <tr>
            <th style="background-color: #333333; color: #FFFFFF;">Category</th>
            <th style="background-color: #333333; color: #FFFFFF;">Date</th>
            <th style="background-color: #333333; color: #FFFFFF;">Name</th>
            <th style="background-color: #333333; color: #FFFFFF;">Amount</th>
            <th style="background-color: #333333; color: #FFFFFF;">Action</th>
        </tr>
        <%  for (String[] expense : expenseList) {
            String deleteURL = "location.href='delete?id=" + expense[4] + "'";
            String editURL = "location.href='edit?id=" + expense[4] + "'";%>
            <tr>
                <td> <%=expense[0]%> </td>
                <td> <%=expense[1]%> </td>
                <td> <%=expense[2]%> </td>
                <td> <%=expense[3]%> </td>
                <td>
                <button onclick=<%=editURL%>>
                <i class="fa-regular fa-pen-to-square"></i></button>
                <button onclick=<%=deleteURL%>>
                <i class="fa-solid fa-trash-can"></i></button> </td>
            </tr>
        <% } %>
    </table>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>