package edit;

import database.ConnectJDBC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/edit")
public class EditExpenseServlet extends HttpServlet {

    ConnectJDBC connectJDBC = new ConnectJDBC();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String[] expenseData = new String[5];

        try {
            connection = connectJDBC.getConnection();
            String sqlQuery = "SELECT * FROM expense_manager WHERE id=?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, Integer.parseInt(id));
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                expenseData[0] = resultSet.getString("category");
                expenseData[1] = resultSet.getString("date");
                expenseData[2] = resultSet.getString("name");
                expenseData[3] = resultSet.getString("amount");
                expenseData[4] = String.valueOf(resultSet.getInt("id"));
            }
            req.setAttribute("expenseData", expenseData);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("edit.jsp");
            requestDispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String category = req.getParameter("category");
        String date = req.getParameter("date");
        String name = req.getParameter("name");
        String amount = req.getParameter("amount");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = connectJDBC.getConnection();

            String insertSQL = "UPDATE expense_manager SET category=?, date=?, name=?, amount=? WHERE id=?";
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1 , category);
            preparedStatement.setString(2 , date);
            preparedStatement.setString(3 , name);
            preparedStatement.setString( 4, amount);
            preparedStatement.setInt( 5, Integer.parseInt(id));
            preparedStatement.executeUpdate();
            // redirect to home page
            resp.sendRedirect(req.getContextPath() + "/");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
