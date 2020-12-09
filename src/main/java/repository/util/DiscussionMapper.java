package repository.util;

import model.Discussion;
import model.Message;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DiscussionMapper extends ObjectMapper<Discussion> {

    private final ObjectMapper<Message> messageMapper = new MessageMapper();

    @Override
    protected Discussion map(ResultSet resultSet) throws SQLException {
        return Discussion.builder()
                .topic(resultSet.getString("topic"))
                .messages(messageMapper.mapList(resultSet))
                .build();
    }
}
