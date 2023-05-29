<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 29.03.2023
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.tms.calc.entity.OperationType" %>
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
                <input class="form-control" type="text" id="operand1" name="operand1" value="${operation.operand1}">
                <br>
                <p class="error-message">${operand1}</p>
            </div>
            <div class="input-group mb-3 p-3">
                <label class="input-group-text" for="operand2">Operand 2:</label>
                <input class="form-control" type="text" id="operand2" name="operand2" value="${operation.operand2}">
                <br>
                <p class="error-message">${operand2}</p>
            </div>
            <div class="input-group mb-3 p-3">
                <label class="input-group-text" for="operationType">Operation:</label>
                <select class="form-select" id="operationType" name="operationType">
                    <c:choose>
                        <c:when test="${operation == null}">
                            <option value="default" disabled selected>Select operation</option>
                        </c:when>
                        <c:otherwise>
                            <option value="default" disabled>Select operation</option>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${operation != null && operation.operationType.equals(OpertationType.SUM)}">
                            <option value="SUM" selected>SUM</option>
                        </c:when>
                        <c:otherwise>
                            <option value="SUM">SUM</option>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${operation != null && operation.operationType.equals(OpertationType.SUB)}">
                            <option value="SUB" selected>SUB</option>
                        </c:when>
                        <c:otherwise>
                            <option value="SUB">SUB</option>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${operation != null && operation.operationType.equals(OpertationType.MUL)}">
                            <option value="MUL" selected>MUL</option>
                        </c:when>
                        <c:otherwise>
                            <option value="MUL">MUL</option>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${operation != null && operation.operationType.equals(OpertationType.DIV)}">
                            <option value="DIV" selected>DIV</option>
                        </c:when>
                        <c:otherwise>
                            <option value="DIV">DIV</option>
                        </c:otherwise>
                    </c:choose>
                </select>
                <br>
                <p class="error-message">${operationType}</p>
            </div>
            <div class="input-group mb-3 p-3">
                <label class="input-group-text" for="calc-result">Result:</label>
                <input class="form-control" disabled id="calc-result" name="calc-result" value="${operation.result}">
            </div>
            <div class="mb-3 d-grid p-3">
                <button class="btn btn-primary">Calculate</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
