package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    // Other methods...

    public static List<Product> getAllProducts() {
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
        return products;
    }

	public static List<BuyLater> getAllBuyLater() {
		List<BuyLater> buyLaterList = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM buy_later";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    BuyLater bl = new BuyLater();
                    bl.setUserName(resultSet.getString("username"));
                    bl.setId((int)resultSet.getInt("product_id"));
                    buyLaterList.add(bl);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions properly in a real-world application
        }
        return buyLaterList;
	}

    // Other methods...
}
