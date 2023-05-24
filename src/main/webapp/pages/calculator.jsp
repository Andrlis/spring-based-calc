<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 29.03.2023
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<div class="col-md-4 offset-md-4 align-items-center mt-3">
    <div class="card">
        <form action="calculate" method="post">
            <div class="input-group mb-3 p-3">
                <label class="input-group-text" for="operand1">Operand 1:</label>
                <input class="form-control" type="text" id="operand1" name="operand1">
                <br>
                <p class="error-message">${operand1}</p>
            </div>
            <div class="input-group mb-3 p-3">
                <label class="input-group-text" for="operand2">Operand 2:</label>
                <input class="form-control" type="text" id="operand2" name="operand2">
                <br>
                <p class="error-message">${operand2}</p>
            </div>
            <div class="input-group mb-3 p-3">
                <label class="input-group-text" for="operation-type">Operation:</label>
                <select class="form-select" id="operation-type" name="operation-type">
                    <option value="default" disabled selected>Select operation</option>
                    <option value="SUM">SUM</option>
                    <option value="SUB">DIV</option>
                    <option value="MUL">MUL</option>
                    <option value="DIV">DIV</option>
                </select>
                <br>
                <p class="error-message">${operation-type}</p>
            </div>
            <div class="input-group mb-3 p-3">
                <label class="input-group-text" for="calc-result">Result:</label>
                <input class="form-control" disabled id="calc-result" name="calc-result">
            </div>
            <div class="mb-3 d-grid p-3">
                <button class="btn btn-primary">Calculate</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
