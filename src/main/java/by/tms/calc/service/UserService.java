package by.tms.calc.service;

import by.tms.calc.dto.UserLoginDTO;
import by.tms.calc.dto.UserRegistrationDTO;
import by.tms.calc.entity.User;
import by.tms.calc.storage.UserStorage;

import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 27/03/2023 - 21:24
 */
public class UserService {

    private UserStorage userStorage;

    public void save(UserRegistrationDTO userRegistrationDTO) {
        User user = User.builder()
                .setUsername(userRegistrationDTO.getUsername())
                .setPassword(userRegistrationDTO.getPassword())
                .setName(userRegistrationDTO.getName())
                .build();
        userStorage.save(user);
    }

    public Optional<User> loginUser(UserLoginDTO userLoginDTO) {
        return userStorage.getByUsername(userLoginDTO.getUsername());
    }


}
