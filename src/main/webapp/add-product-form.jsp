<!-- add-product-form.jsp -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Product</title>
</head>
<body>
	<%@include file="navbar.jsp" %>
    <h2>Add New Product</h2>
    <form action="AddProductServlet" method="post">
        <label for="name">Product Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="price">Product Price:</label>
        <input type="text" id="price" name="price" required><br>

        <!-- Add more fields as needed -->

        <input type="submit" value="Add Product">
    </form>
</body>
</html>
