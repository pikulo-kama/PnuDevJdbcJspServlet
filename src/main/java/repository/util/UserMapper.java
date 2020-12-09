package repository.util;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper extends ObjectMapper<User> {

    @Override
    protected User map(ResultSet resultSet) throws SQLException {
        return User.builder()
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .enabled(resultSet.getBoolean("enabled"))
                .build();
    }
}
