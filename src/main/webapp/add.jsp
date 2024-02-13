<!doctype html>
<html lang="en">
<head>
    <title>Add Expense</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <h2>Add Expense</h2>
    <form action="addExpense" method="post">
        <div class="form-group">
            <label  for="category">Category:</label>
            <select name="category" id="category">
                <option value="Transportation">Transportation</option>
                <option value="Food">Food</option>
                <option value="Fees">Fees</option>
                <option value="Bills">Bills</option>
                <option value="Entertainment">Entertainment</option>
            </select>
        </div>
        <div class="form-group">
            <label for="date">Date: &nbsp </label>
            <input type="date" name="date" id="date">
        </div>
        <div class="form-group">
            <label for="name">Expense Name:</label>
            <input type="text" name="name" id="name">
        </div>
        <div class="form-group">
            <label for="amount">Amount:</label> <br>
            <input type="number" name="amount" id="amount" step="0.01">
        </div>
        <div class="form-group">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>