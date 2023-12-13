package web.website.DAO;

import web.website.database.ConnectionManager;
import web.website.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private final String TABLE = "users";

    public User findByEmail(String email) {
        String sql = "SELECT * FROM " + TABLE + " WHERE email = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResult(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private User mapResult(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getString("email"),
                resultSet.getString("password")
        );
    }
}
