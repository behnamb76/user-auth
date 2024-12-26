<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div>
    <div class="container">
        <h2>LOGIN</h2>
        <%
            String signup = (String) request.getAttribute("signup");
            if (signup != null) {
        %>
        <p><%= signup %></p>
        <%
            }
        %>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
        <p class="text-danger"><%= message %></p>
        <%
            }
        %>
        <form action="dashboard" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" name="username" id="username" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" id="password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
            <a href="index.jsp">Signup</a>
        </form>
    </div>
</div>
</body>
</html>
