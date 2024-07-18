<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD BOOK</title>
<style type="text/css">
    body {
        background-image: url('lib2.jpeg');
        background-size: cover;
        height: 600px; 
        margin: 0;
        display: flex; 
        justify-content: center; 
        align-items: center; 
    }

    div {
        height: auto;
        width: 300px;
        text-align: center;
        border: 2px solid green;
        padding: 20px;
        background-color: transparent;
    }

    input::placeholder {
        color: red;
    }

    input[type="text"] {
        width: 200px;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="text"]:focus {
        border-color: dodgerblue;
    }

    input[type="submit"] {
        background-color: transparent;
        color: green;
        border: none;
        padding: 10px 20px;
        text-align: center;
        font-size: 16px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: green;
        color: darkgreen;
    }

    h2 {
        color: green;
        margin-bottom: 20px;
    }

    button {
        background-color: transparent;
        border: none;
        color: red;
        font-size: 16px;
        cursor: pointer;
        text-decoration: none;
    }
    button:focus {
        background-color: blue;
        color: darkgreen;
    }

    button:hover {
        color: blue; 
    }
   
</style>
</head>
<body>
<div>
    <h2>ADD BOOK DETAILS</h2>
    <form action="addBook2" method="post">
        <input type="text" name="bookid" placeholder="BOOK ID">
        <br><br>
        <input type="text" name="bookname" placeholder="BOOK NAME">
        <br><br>
        <input type="text" name="bookprice" placeholder="BOOK PRICE">
        <br><br>
        <button type="submit">Submit</button>
    </form>
    <br>
    <button id="gt"><a href="Home.jsp">Back to Home</a></button>
</div>
</body>
</html>
