package by.tms.calc.storage;

import by.tms.calc.entity.User;

import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 24/05/2023 - 16:11
 */
public interface UserStorage {
    void save(User user);
    Optional<User> getByUsername(String username);
    void delete(User user);
    void update(User user);
}
