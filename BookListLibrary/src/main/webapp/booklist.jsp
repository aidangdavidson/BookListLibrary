<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
</head>
<body>
    <h1>Book List</h1>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.getId()}</td>
                <td>${book.getTitle()}</td>
                <td>${book.getAuthor()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
