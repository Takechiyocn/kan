package com.tacos.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.tacos.domain.User;
import com.tacos.service.UserDetailsService;
import com.tacos.service.UserRepository;

/**
 * @description: Service：
 * @author: Kan
 * @date: 2021/3/10 22:51
 */
@Service
public class UserRepositoryUserDetailsService
        implements UserDetailsService {
    private UserRepository userRepo;

    // 注入UserRepository
    @Autowired
    public UserRepositoryUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException(
                "User '" + username + "' not found");
    }
}
