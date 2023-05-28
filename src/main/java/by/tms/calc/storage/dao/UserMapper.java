package by.tms.calc.storage.dao;

import by.tms.calc.entity.User;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 28/05/2023 - 13:54
 */
public class UserMapper implements RowMapper<Optional<User>> {
    @Override
    public Optional<User> mapRow(ResultSet rs, int rowNum) throws SQLException {

        if (rs.next()) {
            User user = User.builder()
                    .setId(rs.getLong("user_id"))
                    .setName(rs.getString("name"))
                    .setUsername(rs.getString("username"))
                    .setPassword(rs.getString("password"))
                    .build();
            return Optional.of(user);

        } else {
            return Optional.empty();
        }
    }
}
