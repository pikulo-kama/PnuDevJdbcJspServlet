package repository.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PooledConnectionProvider implements ConnectionProvider{

    private final DataSource dataSource;

    private static final PooledConnectionProvider instance = new PooledConnectionProvider();

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    private PooledConnectionProvider() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://localhost/demo");
        config.setUsername("postgres");
        config.setPassword("root");

        config.setMinimumIdle(5);

        config.setMaximumPoolSize(1500);

        dataSource = new HikariDataSource(config);
    }

    public static PooledConnectionProvider getInstance() {
        return instance;
    }
}
