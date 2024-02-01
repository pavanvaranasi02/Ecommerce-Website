package com.ecommerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteFromBuyLaterServlet")
public class DeleteFromBuyLaterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the Buy Later ID from the request
        int buyLaterId = Integer.parseInt(request.getParameter("buyLaterId"));

        // Get the username from the session (assuming you have a session attribute named "user")
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUserName();

        // Delete the item from the Buy Later list
        deleteFromBuyLater(username, buyLaterId);

        // Redirect back to the Buy Later list page
        response.sendRedirect("buy-later-list.jsp");
    }

    private void deleteFromBuyLater(String username, int buyLaterId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM buy_later WHERE username = ? AND product_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, buyLaterId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
