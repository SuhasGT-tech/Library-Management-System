<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIBRARY</title>
<style type="text/css">
    body {
        background-image: url('images/LIBRARY2.jpg');
        background-size: cover;
        height: 100vh;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    button {
        color: yellow;
        font-size: 20px;
        border: none;
        background: none;
    }

    button:hover {
        cursor: pointer;
        color: white; 
        background-color: blue; 
    }
</style>
</head>
<body>
    <form action="addBook.jsp" method="post">
        <button type="submit">Add New Book</button>
    </form>
    <br>
    <form action="updateBook.jsp" method="post">
        <button type="submit">Update Book Details</button>
    </form>
    <br>
    <form action="FindAllBooks" method="get">
        <button type="submit">Manage Details</button>
    </form>
</body>
</html>
