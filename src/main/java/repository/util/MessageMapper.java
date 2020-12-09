package repository.util;

import model.Discussion;
import model.Message;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper extends ObjectMapper<Message> {

    private final ObjectMapper<User> userMapper = new UserMapper();
    private final ObjectMapper<Discussion> discussionMapper = new DiscussionMapper();

    @Override
    protected Message map(ResultSet resultSet) throws SQLException {
        return Message.builder()
                .message(resultSet.getString("message"))
                .author(userMapper.mapObject(resultSet).get())
                .discussion(discussionMapper.mapObject(resultSet).get())
                .publicationDate(resultSet.getTimestamp("registrationDate").toLocalDateTime())
                .build();
    }
}
