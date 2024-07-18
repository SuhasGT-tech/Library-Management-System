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

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {

    String sql_UPDATE = "UPDATE lms SET bookname = ?, bookprice = ? WHERE bookid = ?";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int bookId = Integer.parseInt(request.getParameter("bookid"));
        String bookName = request.getParameter("bookname");
        String bookPrice = request.getParameter("bookprice");

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "suhas13");
             PreparedStatement stmt = conn.prepareStatement(sql_UPDATE)) {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.setString(1, bookName);
            stmt.setString(2, bookPrice);
            stmt.setInt(3, bookId);

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                response.getWriter().println("<h2>Record updated successfully!</h2>");
                response.sendRedirect("updateBook.jsp");
            } else {
                response.getWriter().println("<h2>Failed to update record!</h2>");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            response.getWriter().println("<h2>Error: " + ex.getMessage() + "</h2>");
        }
    }
}
