package by.tms.calc.storage.dao;

import javax.sql.DataSource;

import by.tms.calc.entity.User;
import by.tms.calc.storage.UserStorage;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 28/05/2023 - 13:46
 */
@Component
public class UserTemplateJDBC implements UserStorage {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    private final String INSERT_SQL = "insert into users (name, username, password) values (?, ?, ?)";
    private final String GET_BY_USERNAME_SQL = "select * from users where username = ?";
    private final String DELETE_SQL = "delete from users where user_id = ?";
    private final String UPDATE_SQL = "update users set name = ?, username = ?, password = ? where user_id = ?";

   public UserTemplateJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        jdbcTemplateObject.update(INSERT_SQL, user.getName(), user.getUsername(), user.getPassword());
    }

    @Override
    public Optional<User> getByUsername(String username) {
        try {
            return Optional.of(jdbcTemplateObject.queryForObject(GET_BY_USERNAME_SQL, new UserMapper(), username));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void delete(User user) {
        jdbcTemplateObject.update(DELETE_SQL, user.getId());
    }

    @Override
    public void update(User user) {
        jdbcTemplateObject.update(UPDATE_SQL, user.getName(), user.getUsername(), user.getPassword(), user.getId());
    }
}
