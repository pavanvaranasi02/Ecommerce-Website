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

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        
        // Create a new Product instance
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);

        // Insert the new product into the database
        insertProduct(newProduct);

        // Redirect to a confirmation page or product listing page
        response.sendRedirect(request.getContextPath() + "/products");
    }
    
    private void insertProduct(Product product) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, product.getName());
                preparedStatement.setDouble(2, product.getPrice());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
