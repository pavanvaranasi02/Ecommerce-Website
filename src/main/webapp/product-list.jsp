<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Listing</title>
    <style>
    	.product-container {
		    position: relative;
		    border: 1px solid #ddd;
		    padding: 10px;
		    margin-bottom: 10px;
		}
		
		.buy-later-btn {
		    position: absolute;
		    top: 0;
		    right: 0;
		    padding: 5px;
		    background-color: #4CAF50;
		    color: white;
		    border: none;
		    cursor: pointer;
		}
    </style>
    <!-- Inside your HTML or JSP file, include the JavaScript function -->
    
</head>
<body>
	<%@include file="navbar.jsp" %>

    <h2>Product Listing</h2>
    
    <%
        List<com.ecommerce.Product> products = (List<com.ecommerce.Product>) request.getAttribute("products");
    	if (products != null) {
    		for (com.ecommerce.Product product : products)  {
    %>
        <!-- Inside the product-list.jsp div -->
		<div class="product-container">
		    <!-- Add Buy Later Button -->
		    <form action="AddToBuyLaterServlet" method="post">
		        <input type="hidden" name="productId" value="<%= product.getId() %>">
		        <button class="buy-later-btn" type="submit" <% if (product.isBuyLater()) { %>disabled<% } %>>
		        	Buy Later
		        </button>
		    </form>
		    <div class="product-details">
		        <h3><%= product.getName() %></h3>
		        <p>ID: <%= product.getId() %></p>
		        <p>Price: <%= product.getPrice() %></p>
		        <img src="<%= product.getImageUrl() %>" alt="Product Image" style="max-width: 300px; max-height: 300px;">
		        <p><%= product.getProductInfo() %></p>
		    </div>
		</div>

    <%
        	} 
    	} else {
		    // Handle the case when the products list is null
		    out.println("No products available.");
		}
    %>
</body>
</html>
