<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ecommerce.User" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.function.Supplier" %>
<%@ page import="java.util.function.Predicate" %>
<%@ page import="java.util.function.Consumer" %>
<%@ page import="java.util.function.Function" %>

<html>
<head>
    <title>Dashboard</title>
</head>
<body>
		<%@include file="navbar.jsp" %>
    	<h2>Dashboard</h2>
        <% 
        	User user = (User) session.getAttribute("user");
            if (user != null) {
                out.print("<div>Logged in as: " + user.getUserName() + "</div>");
            }
        %>
</body>
</html>
