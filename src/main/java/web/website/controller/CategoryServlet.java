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

            Connection conn = ConnectionManager.getConnection();
            ArrayList<Category> categories = new ArrayList<>();

            //paginate


            String pageStr = request.getParameter("page");
            int page = 1;
            if (pageStr != null && !pageStr.isEmpty()) {
                page = Integer.parseInt(pageStr);
            }

            int limit = 100;

            int offset = (page - 1) * limit;

            String sql = "SELECT * FROM category LIMIT ? OFFSET ?";

            //get data from database
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, limit);
            ps.setInt(2, offset);


            ResultSet rs = null;
            rs = ps.executeQuery();

            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"), rs.getString("name")));
            }

            request.setAttribute("categories", categories);

            request.getRequestDispatcher("list_category.jsp").forward(request, response);
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