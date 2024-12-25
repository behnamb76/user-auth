<%@ page import="javax.validation.ConstraintViolation" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Signup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div>
    <div class="container">
        <h2>SIGNUP</h2>
        <%
            ConstraintViolation<?> error = (ConstraintViolation<?>) request.getAttribute("Error");
            if (error != null) {
        %>
        <p class="text-danger"><%= error.getMessage() %></p>
        <%
            }
        %>
        <form action="signup" method="post">
            <div class="mb-3">
                <label for="firstname" class="col-form-label">Firstname</label>
                <input type="text" name="firstname" id="firstname" class="form-control" value="<%= request.getParameter("firstname") != null ? request.getParameter("firstname") : "" %>">
            </div>
            <div class="mb-3">
                <label for="lastname" class="form-label">Lastname</label>
                <input type="text" name="lastname" id="lastname" class="form-control" value="<%= request.getParameter("lastname") != null ? request.getParameter("lastname") : "" %>">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" name="email" id="email" class="form-control" value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">
            </div>
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" name="username" id="username" class="form-control" value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" id="password" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Register Now</button>
            <a href="login.jsp">Login</a>
        </form>
    </div>
</div>
</body>
</html>