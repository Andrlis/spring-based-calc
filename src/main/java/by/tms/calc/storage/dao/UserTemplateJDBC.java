package by.tms.calc.storage.dao;

import javax.sql.DataSource;

import by.tms.calc.entity.User;
import by.tms.calc.storage.UserStorage;
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

   UserTemplateJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        String SQL = "insert into users (name, username, password) values (?, ?, ?)";
        jdbcTemplateObject.update(SQL, user.getName(), user.getUsername(), user.getPassword());
    }

    @Override
    public Optional<User> getByUsername(String username) {
        String SQL = "select * from users where username = ?";

        Optional<User> byUsername = jdbcTemplateObject.queryForObject(SQL, new UserMapper(), new Object[]{username});

        return byUsername;
    }

    @Override
    public void delete(User user) {
        String SQL = "delete from users where user_id = ?";
        jdbcTemplateObject.update(SQL, user.getId());
    }

    @Override
    public void update(User user) {
        String SQL = "update users set name = ?, username = ?, password = ? where user_id = ?";
        jdbcTemplateObject.update(SQL, user.getName(), user.getUsername(), user.getPassword(), user.getId());
    }
}
