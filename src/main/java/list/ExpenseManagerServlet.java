package list;

import database.ConnectJDBC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/")
public class ExpenseManagerServlet extends HttpServlet {

    ConnectJDBC connectJDBC = new ConnectJDBC();

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String[]> expenseList = new ArrayList<>();

        try {
            connection = connectJDBC.getConnection();
            String sqlQuery = "SELECT * FROM expense_manager";
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String[] expenseData = new String[5];
                expenseData[0] = resultSet.getString("category");
                expenseData[1] = resultSet.getString("date");
                expenseData[2] = resultSet.getString("name");
                expenseData[3] = resultSet.getString("amount");
                expenseData[4] = String.valueOf(resultSet.getInt("id"));
                expenseList.add(expenseData);
            }
            servletRequest.setAttribute("expenseList", expenseList);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("home.jsp");
            requestDispatcher.forward(servletRequest, servletResponse);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
