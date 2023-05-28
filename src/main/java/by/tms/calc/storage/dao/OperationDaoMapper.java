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

        return Operation.builder()
                .setId(rs.getLong("id"))
                .setOperand1(rs.getDouble("operand1"))
                .setOperand2(rs.getDouble("operand2"))
                .setOperationType(OperationType.valueOf(rs.getString("operation_type")))
                .setResult(rs.getDouble("result"))
                .setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime())
                .setAuthor(author)
                .build();
    }
}
