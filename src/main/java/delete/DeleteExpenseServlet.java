package delete;

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

@WebServlet(value = "/delete")
public class DeleteExpenseServlet extends HttpServlet {

    ConnectJDBC connectJDBC = new ConnectJDBC();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("Delete: " + id);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = connectJDBC.getConnection();

            String deleteSQL = "DELETE FROM expense_manager WHERE id=?";
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt( 1, Integer.parseInt(id));
            preparedStatement.executeUpdate();
            // redirect to home page
            resp.sendRedirect(req.getContextPath() + "/");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
