package by.tms.calc.service;

import by.tms.calc.entity.User;
import by.tms.calc.storage.UserStorage;

import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 27/03/2023 - 21:24
 */
public class UserService {

    private UserStorage userStorage;

    public void save(User user){};

    public Optional<User> findByUserName(String username){
        return Optional.empty();
    }

    public Optional<User> loginUser(User user){
        return Optional.empty();
    }


}
