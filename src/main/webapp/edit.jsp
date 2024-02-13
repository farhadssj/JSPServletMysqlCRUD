<!doctype html>
<html lang="en">
<head>
    <title>Add Expense</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<%@ include file="header.jsp" %>
<%
String[] expenseData = (String[]) request.getAttribute("expenseData");
%>
<div class="container">
    <h2>Edit Expense</h2>
    <form action="edit" method="post">
        <div class="form-group">
            <label  for="category">Category:</label>
            <select name="category" id="category">
                <option value="Transportation" <% if(expenseData[0].equals("Transportation")){%>selected<%}%>>Transportation</option>
                <option value="Food" <% if(expenseData[0].equals("Food")){%>selected<%}%>>Food</option>
                <option value="Fees" <% if(expenseData[0].equals("Fees")){%>selected<%}%>>Fees</option>
                <option value="Bills" <% if(expenseData[0].equals("Bills")){%>selected<%}%>>Bills</option>
                <option value="Entertainment" <% if(expenseData[0].equals("Entertainment")){%>selected<%}%>>Entertainment</option>
            </select>
        </div>
        <div class="form-group">
            <label for="date">Date: &nbsp </label>
            <input type="date" name="date" id="date" value=<%=expenseData[1]%>>
        </div>
        <div class="form-group">
            <label for="name">Expense Name:</label>
            <input type="text" name="name" id="name" value=<%=expenseData[2]%>>
        </div>
        <div class="form-group">
            <label for="amount">Amount:</label> <br>
            <input type="number" name="amount" id="amount" step="0.01" value=<%=expenseData[3]%>>
        </div>
        <input style="display: none;" type="number" name="id" id="id" value=<%=expenseData[4]%>>
        <div class="form-group">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>