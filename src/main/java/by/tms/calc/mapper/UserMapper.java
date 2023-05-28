package by.tms.calc.mapper;

import by.tms.calc.entity.SessionUser;
import by.tms.calc.entity.User;

/**
 * @author Andrei Lisouski (Andrlis) - 29/05/2023 - 0:25
 */
public class UserMapper {

    public static SessionUser toSessionUser(User user){
        SessionUser sessionUser = new SessionUser();
        sessionUser.setId(user.getId());
        sessionUser.setName(user.getName());
        sessionUser.setUsername(user.getUsername());

        return sessionUser;
    }
}
