<!-- edit-product-form.jsp -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>

<%@include file="navbar.jsp" %>

<h2>Edit Product</h2>
<form action="EditProductServlet" method="post">
    <label for="productId">Product ID to Edit:</label>
    <input type="text" id="productId" name="productId" required><br>
	<label for="name">Product Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="price">Product Price:</label>
    <input type="text" id="price" name="price" required><br>

    <input type="submit" value="Edit Product">
</form>

</body>
</html>
