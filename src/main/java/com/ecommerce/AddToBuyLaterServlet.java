package com.ecommerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddToBuyLaterServlet")
public class AddToBuyLaterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the product ID from the request
        int productId = Integer.parseInt(request.getParameter("productId"));

        // Get the username from the session (assuming you have a session attribute named "user")
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUserName();
        
        List<Product> products = (List<Product>) ProductDAO.getAllProducts();
        HashMap<Integer, Product> hm = new HashMap<>();
        List<BuyLater> buyLaterList = (List<BuyLater>) ProductDAO.getAllBuyLater();
        
        for(Product p: products) {
        	hm.put(p.getId(), p);
        }
        
        boolean isProductIdInBuyLater = false;
        
        for(BuyLater bl: buyLaterList) {
        	if(hm.containsKey(bl.getId())) {
        		Product p = hm.get(bl.getId());
        		p.setBuyLater(true);
        		if(p.getId() == productId) isProductIdInBuyLater = true;
        	}
        }
        
        if(isProductIdInBuyLater) {
        	// do nothing for now.
        } else {
        	boolean added = addToBuyLater(username, productId);
        	if(added) {
        		hm.get(productId).setBuyLater(true);
        	}
        }
        response.sendRedirect("buy-later-list.jsp");
        
    }

    private boolean addToBuyLater(String username, int productId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO buy_later (username, product_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, productId);
                int rowsAffected = preparedStatement.executeUpdate();
                // Commit the transaction if everything is successful
                return rowsAffected>0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return false;
        }
    }
}
