package by.tms.calc.entity;


/**
 * @author Andrei Lisouski (Andrlis)
 */
public class User {
    private long id;

    private String name;

    private String username;

    private String password;

    public User() {
    }

    public static UserBuilder builder() {
        return new User().new UserBuilder();
    }

    public class UserBuilder {
        private UserBuilder() {
        }

        public UserBuilder setId(int id) {
            User.this.id = id;
            return this;
        }

        public UserBuilder setName(String name) {
            User.this.name = name;
            return this;
        }

        public UserBuilder setUsername(String username) {
            User.this.username = username;
            return this;
        }

        public UserBuilder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public User build() {
            return User.this;
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
