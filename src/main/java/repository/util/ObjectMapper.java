package repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class ObjectMapper<T> {

    public List<T> mapList(ResultSet resultSet) {
        try (resultSet) {
            List<T> objects = new ArrayList<T>();

            while (resultSet.next()) {
                objects.add(map(resultSet));
            }

            return objects;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    public Optional<T> mapObject(ResultSet resultSet) {
        try (resultSet) {
            if (resultSet.next())
                return Optional.of(map(resultSet));

            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    protected abstract T map(ResultSet resultSet) throws SQLException;

}
