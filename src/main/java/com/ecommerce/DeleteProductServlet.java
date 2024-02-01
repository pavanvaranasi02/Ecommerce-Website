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

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        int productId = Integer.parseInt(request.getParameter("productId"));

        // Delete the product from the database
        deleteProduct(productId);

        // Redirect to a confirmation page or product listing page
        response.sendRedirect(request.getContextPath() + "/products");
    }

    private void deleteProduct(int productId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM products WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
