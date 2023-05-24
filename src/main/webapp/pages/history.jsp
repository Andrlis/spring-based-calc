<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24.05.2023
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<div class="container-fluid bg-3 text-center">
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Operand #1</th>
                <th scope="col">Operand #2</th>
                <th scope="col">Operation Type</th>
                <th scope="col">Result</th>
                <th scope="col">User</th>
                <th scope="col">Created At</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="operation" items="${listOfOperations}">
                <tr>
                    <td>${operation.operand1}</td>
                    <td>${operation.operand2}</td>
                    <td>${operation.operationType}</td>
                    <td>${operation.result}</td>
                    <td>${operation.author}</td>
                    <td>${operation.createdAt}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row">
        <c:if test="${requestScope.countOfPages > 1}">
            <div class="text-center">
                <ul class="pagination justify-content-center">
                    <c:choose>
                        <c:when test="${requestScope.page == null || requestScope.page == 1}">
                            <li class="page-item disabled"><a class="page-link" aria-disabled="true"
                                                              href="#">Previous</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link"
                                                     href="/user/history/page/${requestScope.page - 1}">Previous</a>
                            </li>
                        </c:otherwise>
                    </c:choose>


                    <c:forEach var="i" begin="1" end="${requestScope.countOfPages}">
                        <c:choose>
                            <c:when test="${requestScope.page == null || requestScope.page == i}">
                                <li class="page-item active"><a class="page-link"
                                                                href="/user/history/page/${i}"><c:out
                                        value="${i}"/></a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link" href="/user/history/page/${i}"><c:out
                                        value="${i}"/></a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>


                    <c:choose>
                        <c:when test="${requestScope.page == null || requestScope.page == requestScope.countOfPages}">
                            <li class="page-item disabled"><a class="page-link" aria-disabled="true" href="#">Next</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link"
                                                     href="/user/history/page/${requestScope.page + 1}">Next</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
