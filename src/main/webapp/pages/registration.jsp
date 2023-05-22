<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 29.03.2023
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="col-md-4 offset-md-4 align-items-center mt-3">
    <div class="card">
        <form action="calculate" method="post">
            <div class="input-group mb-3 p-3">
                <label class="input-group-text" for="name">Name</label>
                <input class="form-control" type="text" id="name" name="name" required>
            </div>
            <div class="input-group mb-3 p-3">
                <label class="input-group-text" for="username">Username</label>
                <input class="form-control" type="text" id="username" name="userame" required>
            </div>
            <div class="input-group mb-3 p-3">
                <label class="input-group-text" for="password1">Password</label>
                <input class="form-control" type="password" id="password1" name="password1" required>
            </div>
            <div class="input-group mb-3 p-3">
                <label class="input-group-text" for="password2">Repeat password</label>
                <input class="form-control" type="password" id="password2" name="password2" required>
            </div>
            <div class="mb-3 d-grid p-3">
                <button class="btn btn-primary">Register</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>