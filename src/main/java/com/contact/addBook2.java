package com.contact;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addBook2")
public class addBook2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String SQL_INSERT = "INSERT INTO lms (bookid, bookname, bookprice) VALUES (?, ?, ?)";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int bookId = Integer.parseInt(request.getParameter("bookid"));
        String bookName = request.getParameter("bookname");
        double bookPrice = Double.parseDouble(request.getParameter("bookprice"));

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "suhas13");
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.setInt(1, bookId);
            stmt.setString(2, bookName);
            stmt.setDouble(3, bookPrice);

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                response.getWriter().println("<h2>Record inserted successfully!</h2>");
                response.sendRedirect("addBook.jsp");
            } else {
                response.getWriter().println("<h2>Failed to insert record!</h2>");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            response.getWriter().println("<h2>Error: " + ex.getMessage() + "</h2>");
        }
    }
}
