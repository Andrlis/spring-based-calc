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

    OperationTemplateJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Operation operation) {
        String SQL = "insert into operations (operand1, operand2, operation_type, result, created_at, author_id) values (?, ?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(SQL, operation.getOperand1(), operation.getOperand2(),
                operation.getOperationType(), operation.getResult(),
                Timestamp.valueOf(operation.getCreatedAt()), operation.getAuthor().getId());
    }

    @Override
    public void delete(Operation operation) {
        String SQL = "delete from operations where id = ?";
        jdbcTemplateObject.update(SQL, operation.getId());
    }

    @Override
    public void update(Operation operation) {
        String SQL = "update operations set result = ? where id = ?";
        jdbcTemplateObject.update(SQL, operation.getResult(), operation.getId());
    }

    @Override
    public List<Operation> getAllByUser(User user) {
        String SQL = "select * from operations join users on operations.author_id = users.user_id where user_id = ?";
        return jdbcTemplateObject.query(SQL, new OperationMapper());
    }
}
