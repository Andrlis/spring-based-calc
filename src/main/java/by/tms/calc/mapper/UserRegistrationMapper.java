package by.tms.calc.mapper;

import by.tms.calc.dto.UserRegistrationDTO;
import by.tms.calc.entity.User;

/**
 * @author Andrei Lisouski (Andrlis) 29/05/2023 - 17:34
 */
public class UserRegistrationMapper {
    public static User toUser(UserRegistrationDTO registrationDTO){
        return User.builder()
                .setName(registrationDTO.getName())
                .setUsername(registrationDTO.getUsername())
                .setPassword(registrationDTO.getPassword())
                .build();
    }
}
