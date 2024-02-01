<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.BuyLater" %>
<%@ page import="com.ecommerce.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy Later List</title>
    <style>
        .buy-later-container {
            position: relative;
            border: 1px solid #ddd;
            padding: 10px;
            margin-bottom: 10px;
        }

        .product-details {
            /* Add any styling for product details */
        }

        .delete-btn {
            position: absolute;
            top: 5px;
            right: 5px;
            background-color: #ff0000;
            color: white;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <%@include file="navbar.jsp" %>

    <h2>Buy Later List</h2>

    <%
        List<BuyLater> buyLaterList = (List<BuyLater>) ProductDAO.getAllBuyLater();
        if (buyLaterList != null && !buyLaterList.isEmpty()) {
            for (BuyLater bl : buyLaterList) {
    %>
                <!-- Inside the buy-later-list.jsp div -->
                <div class="buy-later-container">
                    <div class="product-details">
                        <h3>ID: <%= bl.getId() %></h3>
                    </div>
                    <form action="DeleteFromBuyLaterServlet" method="post">
                        <input type="hidden" name="buyLaterId" value="<%= bl.getId() %>">
                        <button class="delete-btn" type="submit">Delete</button>
                    </form>
                </div>
    <%
            }
        } else {
            // Handle the case when the buy later list is empty
            out.println("No products in Buy Later list.");
        }
    %>
</body>
</html>
