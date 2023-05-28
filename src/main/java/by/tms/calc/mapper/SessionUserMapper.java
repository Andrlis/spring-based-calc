package by.tms.calc.mapper;

import by.tms.calc.entity.SessionUser;
import by.tms.calc.entity.User;

/**
 * @author Andrei Lisouski (Andrlis) - 29/05/2023 - 0:57
 */
public class SessionUserMapper {

    public static User toUser(SessionUser sessionUser){
        return User.builder()
                .setId(sessionUser.getId())
                .setName(sessionUser.getName())
                .setUsername(sessionUser.getUsername())
                .build();
    }
}
