<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Libraries and Books</title>
</head>
<body>
    <h1>Libraries and Books</h1>
    
    <c:if test="${not empty libraries}">
        <c:forEach var="library" items="${libraries}">
            <h2>${library.name}</h2>
            <ul>
                <c:if test="${not empty library.books}">
                    <c:forEach var="book" items="${library.books}">
                        <li>${book.title} by ${book.author}</li>
                    </c:forEach>
                </c:if>
                <c:if test="${empty library.books}">
                    <li>No books available</li>
                </c:if>
            </ul>
        </c:forEach>
    </c:if>
    <c:if test="${empty libraries}">
        <p>No libraries available</p>
    </c:if>
</body>
</html>
