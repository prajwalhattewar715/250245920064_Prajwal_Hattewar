package com.book.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String jdbcURL = "jdbc:mysql://localhost:3306/bookdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_password";

    private Connection getConnection() throws SQLException {
        try { Class.forName("com.mysql.cj.jdbc.Driver"); } 
        catch (ClassNotFoundException e) { e.printStackTrace(); }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action == null ? "LIST" : action) {
                case "NEW": showNewForm(request, response); break;
                case "EDIT": showEditForm(request, response); break;
                case "DELETE": deleteBook(request, response); break;
                default: listBook(request, response); break;
            }
        } catch (SQLException ex) { throw new ServletException(ex); }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            if ("INSERT".equals(action)) insertBook(request, response);
            else if ("UPDATE".equals(action)) updateBook(request, response);
        } catch (SQLException ex) { throw new ServletException(ex); }
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) { list.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"))); }
        }
        request.setAttribute("listBook", list);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = null;
        String sql = "SELECT * FROM books WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price")); }
        }
        request.setAttribute("book", book);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title); stmt.setString(2, author); stmt.setDouble(3, price); stmt.executeUpdate();
        }
        response.sendRedirect("BookServlet");
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        String sql = "UPDATE books SET title=?, author=?, price=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title); stmt.setString(2, author); stmt.setDouble(3, price); stmt.setInt(4, id); stmt.executeUpdate();
        }
        response.sendRedirect("BookServlet");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String sql = "DELETE FROM books WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id); stmt.executeUpdate();
        }
        response.sendRedirect("BookServlet");
    }
}