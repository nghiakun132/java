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
import java.util.ArrayList;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            String idStr = request.getParameter("id");

            if (action != null && action.equals("delete") && idStr != null && !idStr.isEmpty()) {
                int id = Integer.parseInt(request.getParameter("id"));

                Connection conn = ConnectionManager.getConnection();

                String sql = "DELETE FROM category WHERE id = ?";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);

                ps.executeUpdate();

                response.sendRedirect(request.getContextPath() + "/category");
                return;
            }

            Connection conn = ConnectionManager.getConnection();
            ArrayList<Category> categories = new ArrayList<>();


            String sql = "SELECT * FROM category ORDER BY id DESC";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = null;
            rs = ps.executeQuery();

            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"), rs.getString("name")));
            }

            request.setAttribute("categories", categories);

            request.getRequestDispatcher("pages/category/list_category.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        try {
            Connection conn = ConnectionManager.getConnection();

            String sql = "INSERT INTO category (name) VALUES (?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);

            ps.executeUpdate();

            response.sendRedirect(request.getContextPath() + "/category");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}