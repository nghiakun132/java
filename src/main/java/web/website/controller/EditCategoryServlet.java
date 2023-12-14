package web.website.controller;

import web.website.database.ConnectionManager;
import web.website.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "EditCategoryServlet", value = "/edit-category")
public class EditCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            Connection conn = ConnectionManager.getConnection();

            String sql = "SELECT * FROM category WHERE id = ?";

            PreparedStatement ps = null;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                request.setAttribute("category", category);
                request.getRequestDispatcher("pages/category/edit_category.jsp").forward(request, response);

            } else {
                response.sendRedirect(request.getContextPath() + "/category");
                return;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            System.out.println(name + " " + id);
            Connection conn = ConnectionManager.getConnection();

            String sql = "UPDATE category SET name = ? WHERE id = ?";

            PreparedStatement ps = null;
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();

            response.sendRedirect(request.getContextPath() + "/category");
            return;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}