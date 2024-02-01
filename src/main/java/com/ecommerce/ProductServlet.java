package com.ecommerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM products";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId((int)resultSet.getInt("id"));
                    product.setName((String)resultSet.getString("name"));
                    product.setPrice((double)resultSet.getDouble("price"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions properly in a real-world application
        }

        request.setAttribute("products", products);
        request.getRequestDispatcher("product-list.jsp").forward(request, response);
    }
    
}
