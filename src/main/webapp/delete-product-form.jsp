<!-- delete-product-form.jsp -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
	<%@include file="navbar.jsp" %>
    <h2>Delete Product</h2>
    <form action="DeleteProductServlet" method="post">
        <label for="productId">Product ID to Delete:</label>
        <input type="text" id="productId" name="productId" required><br>

        <input type="submit" value="Delete Product">
    </form>
</body>
</html>
