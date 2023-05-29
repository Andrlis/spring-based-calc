package by.tms.calc.storage.dao;

import by.tms.calc.entity.Operation;
import by.tms.calc.entity.OperationType;
import by.tms.calc.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Andrei Lisouski (Andrlis) - 28/05/2023 - 14:25
 */
public class OperationDaoMapper implements RowMapper<Operation> {
    @Override
    public Operation mapRow(ResultSet rs, int rowNum) throws SQLException {
        User author = User.builder()
                .setId(rs.getLong("user_id"))
                .setName(rs.getString("name"))
                .setUsername(rs.getString("username"))
                .setPassword(rs.getString("password"))
                .build();

        Operation operation = new Operation();
        operation.setId(rs.getLong("id"));
        operation.setOperand1(rs.getDouble("operand1"));
        operation.setOperand2(rs.getDouble("operand2"));
        operation.setOperationType(OperationType.valueOf(rs.getString("operation_type")));
        operation.setResult(rs.getDouble("result"));
        operation.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        operation.setAuthor(author);

        return operation;
    }
}
