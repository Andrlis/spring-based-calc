package by.tms.calc.storage.dao;

import by.tms.calc.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 28/05/2023 - 13:54
 */
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .setId(rs.getLong("user_id"))
                .setName(rs.getString("name"))
                .setUsername(rs.getString("username"))
                .setPassword(rs.getString("password"))
                .build();
    }
}
