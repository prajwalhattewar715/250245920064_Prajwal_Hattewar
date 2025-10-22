package com.login;

import java.io.IOException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loginid = request.getParameter("loginid");
        String password = request.getParameter("password");

        String sql = "SELECT id FROM users WHERE loginid = ? AND password = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, loginid);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // set session attribute if needed
                    HttpSession session = request.getSession();
                    session.setAttribute("loginid", loginid);

                    RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (SQLException e) {
            throw new ServletException("DB error", e);
        }
    }

    // Optional: allow GET to forward to index
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}
