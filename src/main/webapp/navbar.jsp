<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ecommerce.User" %>

<html>
<head>
    <title>Home</title>
    <style>
	    nav {
	        display: flex;
	        justify-content: space-between;
	        background-color: #333;
	        padding: 10px;
	    }
	
	    ul {
	        list-style-type: none;
	        margin: 0;
	        padding: 0;
	        display: flex;
	    }
	
	    li {
	        margin-right: 90px;
	    }
	
	    a {
	        text-decoration: none;
	        color: white;
	    }
	    
	    .username{
	    	text-decoration: none;
	    	color: gold;
	    }
	</style>
</head>
<body>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="/Ecommerce_Website/products">Products</a></li>
            <% User user = (User) session.getAttribute("user");
            	if (user != null) {  %>
             <li><a href="buy-later-list.jsp">Buy Later Id's</a></li>
             <li><a href="add-product-form.jsp">Add Product</a></li>
		     <li><a href="edit-product-form.jsp">Edit Product</a></li>
		     <li><a href="delete-product-form.jsp">Delete Product</a></li>
		        <!-- Add more links as needed -->
            <% } else { %>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
            <% } %>
            <% if (user != null) { %>
	        	<li> <div class="username"> Logged in as: " <%= user.getUserName() %> "</div></li>
	            <li><a href="LogoutServlet">Logout</a></li>
	        <% } %>
        </ul>
        
    </nav>
</body>
</html>
