package by.tms.calc.mapper;

import by.tms.calc.dto.UserLoginDTO;
import by.tms.calc.entity.User;

/**
 * @author Andrei Lisouski (Andrlis) 29/05/2023 - 17:34
 */
public class UserLoginMapper {

    public static User toUser(UserLoginDTO loginDTO){
        return User.builder()
                .setName(loginDTO.getUsername())
                .setUsername(loginDTO.getPassword())
                .build();
    }
}
