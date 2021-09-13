package com.tacos.config.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.tacos.domain.User;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/10 23:38
 */
@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username, passwordEncoder.encode(password),
                fullname, city, state, zip, phone
        );
    }
}
