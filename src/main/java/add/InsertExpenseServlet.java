package add;

import database.ConnectJDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(value = "/addExpense")
public class InsertExpenseServlet extends HttpServlet {

    ConnectJDBC connectJDBC = new ConnectJDBC();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("add.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String category = req.getParameter("category");
        String date = req.getParameter("date");
        String name = req.getParameter("name");
        String amount = req.getParameter("amount");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = connectJDBC.getConnection();

            String insertSQL = "INSERT INTO expense_manager (category, date, name, amount) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1 , category);
            preparedStatement.setString(2 , date);
            preparedStatement.setString(3 , name);
            preparedStatement.setString( 4, amount);
            preparedStatement.executeUpdate();
            // redirect to home page
            resp.sendRedirect(req.getContextPath() + "/");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
