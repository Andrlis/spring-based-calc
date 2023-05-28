package by.tms.calc.storage.dao;

import by.tms.calc.entity.Operation;
import by.tms.calc.entity.User;
import by.tms.calc.storage.OperationStorage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis) - 28/05/2023 - 14:37
 */
@Component
public class OperationTemplateJDBC implements OperationStorage {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    private final String INSERT_SQL = "insert into operations (operand1, operand2, operation_type, result, created_at, author_id) values (?, ?, ?, ?, ?, ?)";
    private final String DELETE_SQL = "delete from operations where id = ?";
    private final String UPDATE_SQL = "update operations set result = ? where id = ?";
    private final String GET_ALL_BY_USER_SQL = "select * from operations join users on operations.author_id = users.user_id where user_id = ?";
    private final String GET_BY_USER_WITH_OFFSET_SQL = "select * from operations join users on operations.author_id = users.user_id where user_id = ? order by id ASC limit ? offset ?";
    private final String GET_COUNT_BY_USER_SQL = "select count(*) from operations join users on operations.author_id = users.user_id where user_id = ?";


    public OperationTemplateJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Operation operation) {
        jdbcTemplateObject.update(INSERT_SQL, operation.getOperand1(), operation.getOperand2(),
                operation.getOperationType().toString(), operation.getResult(),
                Timestamp.valueOf(operation.getCreatedAt()), operation.getAuthor().getId());
    }

    @Override
    public void delete(Operation operation) {
        jdbcTemplateObject.update(DELETE_SQL, operation.getId());
    }

    @Override
    public void update(Operation operation) {
        jdbcTemplateObject.update(UPDATE_SQL, operation.getResult(), operation.getId());
    }

    @Override
    public List<Operation> getAllByUser(User user) {
        return jdbcTemplateObject.query(GET_ALL_BY_USER_SQL, new OperationDaoMapper(), user.getId());
    }

    @Override
    public List<Operation> getAllByUserWithOffset(User user, int limit, int offset) {
        return jdbcTemplateObject.query(GET_BY_USER_WITH_OFFSET_SQL, new OperationDaoMapper(), user.getId(), limit, offset);
    }

    @Override
    public int getCountOfOperationsPerUser(User user) {
        return jdbcTemplateObject.queryForObject(GET_COUNT_BY_USER_SQL, Integer.class, user.getId());
    }
}
