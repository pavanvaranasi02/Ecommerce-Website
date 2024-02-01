<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        /* styles.css */
/* styles.css */

body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
}

.container {
    width: 80%;
    margin: auto;
    overflow: hidden;
}

header {
    background: #ffffff;
    padding: 20px 0;
}

nav {
    float: right;
}

nav ul {
    list-style: none;
    margin: 0;
    padding: 0;
}

nav li {
    display: inline;
    margin-left: 20px;
}

.form-container {
    width: 30%;
    margin: 100px auto;
    background: #ffffff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-container h2 {
    text-align: center;
}

.form-container form {
    margin-top: 20px;
}

.form-container label {
    display: block;
    margin-bottom: 8px;
}

.form-container input {
    width: 100%;
    padding: 8px;
    margin-bottom: 20px;
}

.form-container button {
    background: #4caf50;
    color: #fff;
    padding: 10px;
    border: none;
    width: 100%;
    cursor: pointer;
}


    </style>
</head>
<body>
	<div class="container">
    <div class="form-container">
        <h2>Login</h2>
        <form action="LoginServlet" method="post">
            <!-- Your login form fields here -->
            <div class="form-group">
	                <label for="username">Username:</label>
	                <input type="text" id="username" name="username" required>
	            </div>
	            <div class="form-group">
	                <label for="password">Password:</label>
	                <input type="password" id="password" name="password" required>
	            </div>
	            <div class="form-group">
	                <button type="submit">Login</button>
	            </div>
        </form>
    </div>
</div>
</body>
</html>
