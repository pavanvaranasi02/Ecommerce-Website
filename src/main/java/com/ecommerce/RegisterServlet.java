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
import jakarta.servlet.http.HttpSession;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User newUser = new User();
        newUser.setUserName(username);
        newUser.setPassword(password);

        registerUser(newUser);
        
        newUser.setPassword("");
        // Store the user object in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", newUser);
        response.sendRedirect("index.jsp");
    }

    private void registerUser(User user) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., duplicate username)
        }
    }
}
