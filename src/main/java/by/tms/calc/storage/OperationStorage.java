package by.tms.calc.storage;

import by.tms.calc.entity.Operation;
import by.tms.calc.entity.User;

import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis) - 24/05/2023 - 16:15
 */
public interface OperationStorage {
    void save(Operation operation);
    void delete(Operation operation);
    void update(Operation operation);

    List<Operation> getAllByUser(User user);
}
