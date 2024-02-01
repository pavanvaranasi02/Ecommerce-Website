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

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        int productId = Integer.parseInt(request.getParameter("productId"));
        String name = (String)request.getParameter("name");
        double price = (Double.parseDouble(request.getParameter("price")));

        updateProduct(productId, name, price);

        // Redirect to a confirmation page or product listing page
        response.sendRedirect(request.getContextPath() + "/products");
    }

	private void updateProduct(int productId, String name, double price) {
        try (Connection connection = DatabaseConnection.getConnection()) {
        	String sql = "UPDATE products SET name=?, price=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, price);
                preparedStatement.setInt(3, productId);
                // Set other updated fields as needed
                int rowsAffected = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
