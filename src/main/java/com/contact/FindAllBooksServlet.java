package com.contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FindAllBooks")
public class FindAllBooksServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "suhas13");

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM lms");

            out.println("<html><body>");
            out.println("<h2>Book List</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Book ID</th><th>Book Name</th><th>Book Price</th><th>Actions</th></tr>");

            while (rs.next()) {
                int bookId = rs.getInt("bookid");
                String bookName = rs.getString("bookname");
                String bookPrice = rs.getString("bookprice");
                out.println("<tr>");
                out.println("<td>" + bookId + "</td>");
                out.println("<td>" + bookName + "</td>");
                out.println("<td>" + bookPrice + "</td>");
                out.println("<td>");
                out.println("<form action='DeleteBook' method='post' style='display:inline;'>");
                out.println("<input type='hidden' name='bookid' value='" + bookId + "'>");
                out.println("<button type='submit'>Delete</button>");
                out.println("</form>");
                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<br><button><a href=\"Home.jsp\">Back to Home</a></button>");
            out.println("</body></html>");

            rs.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Exception occurred: " + e.getMessage());
        } finally {
            out.close();
        }
    }
}
