package by.tms.calc.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * @author Andrei Lisouski (Andrlis) - 24/05/2023 - 16:59
 */
public class UserRegistrationDTO {

    @NotBlank(message = "Not Black")
    @NotEmpty(message = "Not Empty")
    private String name;

    @NotBlank(message = "Not Black")
    @NotEmpty(message = "Not Empty")
    private String username;

    @NotBlank(message = "Not Black")
    @NotEmpty(message = "Not Empty")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Not valid password")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
