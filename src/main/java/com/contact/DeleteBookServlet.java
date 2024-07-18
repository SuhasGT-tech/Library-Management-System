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

@WebServlet("/DeleteBook")
public class DeleteBookServlet extends HttpServlet {

    String SQL_DELETE = "DELETE FROM lms WHERE bookid = ?";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookid"));

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "suhas13");
             PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {

            stmt.setInt(1, bookId);

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                response.getWriter().println("<h2>Record deleted successfully!</h2>");
            } else {
                response.getWriter().println("<h2>Failed to delete record!</h2>");
            }
            response.sendRedirect("FindAllBooks");
        } catch (SQLException e) {
            response.getWriter().println("Exception occurred: " + e.getMessage());
        }
    }
}
