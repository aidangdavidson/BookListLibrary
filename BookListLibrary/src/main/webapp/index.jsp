<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Book List</title>
</head>
<body>
    <h1>My Book List</h1>
    
    <h2>Add a New Book</h2>
	<form action="add" method="post">
    	Title: <input type="text" name="title"><br>
    	Author: <input type="text" name="author"><br>
    	Library ID: <input type="text" name="libraryId"><br> 
    	<input type="submit" value="Add Book">
	</form>
    
    <!-- Add a New Library -->
    <h2>Add a New Library</h2>
    <form action="addLibrary" method="post">
        Library Name: <input type="text" name="libraryName"><br>
        <input type="submit" value="Add Library">
    </form>
    
    <h2>Edit Book</h2>
    <form action="edit" method="post">
        Book ID: <input type="text" name="id"><br>
        New Title: <input type="text" name="newTitle"><br>
        New Author: <input type="text" name="newAuthor"><br>
        <input type="submit" value="Edit Book">
    </form>
    
    <h2>Delete Book</h2>
    <form action="delete" method="post">
        Book ID: <input type="text" name="id"><br>
        <input type="submit" value="Delete Book">
    </form>
    
     <h2>Books in Database</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Library</th> 
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.getId()}</td>
                <td>${book.getTitle()}</td>
                <td>${book.getAuthor()}</td>
                <td>${book.getLibrary().getName()}</td> 
            </tr>
        </c:forEach>
    </table>
    
    
</body>
</html>