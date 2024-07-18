<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
</head>
<body>
    <h2>Update Book Details</h2>
    <form action="updateBook" method="post">
        <label for="bookid">Book ID:</label>
        <input type="number" id="bookid" name="bookid" required><br><br>
        <label for="bookname">Book Name:</label>
        <input type="text" id="bookname" name="bookname" required><br><br>
        <label for="bookprice">Book Price:</label>
        <input type="text" id="bookprice" name="bookprice" required><br><br>
        <button type="submit">Update Book</button>
    </form>
</body>
</html>
