package by.tms.calc.service;

import by.tms.calc.dto.UserLoginDTO;
import by.tms.calc.dto.UserRegistrationDTO;
import by.tms.calc.entity.User;
import by.tms.calc.mapper.UserRegistrationMapper;
import by.tms.calc.storage.UserStorage;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 27/03/2023 - 21:24
 */
@Component
public class UserService {

    private UserStorage userStorage;

    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void save(UserRegistrationDTO userRegistrationDTO) {
        User user = UserRegistrationMapper.toUser(userRegistrationDTO);
        userStorage.save(user);
    }

    public Optional<User> loginUser(UserLoginDTO userLoginDTO) {
        return userStorage.getByUsername(userLoginDTO.getUsername());
    }


}
