package com.tacos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
//import com.tacos.service.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * @description:
 * @author: Kan
 * @date: 2021/3/9 23:40
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin();
        http
                .authorizeRequests()
                .antMatchers("/design", "/orders")
                .access("hasRole('ROLE_USER') &&" +
                        // 只允许具备ROLE_USER权限的用户在星期二创建新taco
                        "T(java.util.Calendar).getInstance().get(" +
                        "T(java.util.Calendar).DAY_OF_WEEK) == " +
                        "T(java.util.Calendar).TUESDAY")
                .antMatchers("/", "/**").access("permitAll")
                // and 方法表示已经完成了授权相关配置，并且要添加一些其他http配置
                .and()
                .formLogin()
                .loginPage("/login")
                // 用户登录成功后页面
                .defaultSuccessUrl("/design")
                .and()
                .logout()
                // 退出应用时页面（默认重定向到登陆页面）
                .logoutSuccessUrl("/");
//                .hasRole("ROLE_USER")
//                .antMatchers("/", "/**").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    /**
     * Bean注解的encoder：将来用在Spring应用上下文中声明PasswordEncoder bean。
     * TODO:对于encoder()的任何调用都会被拦截，并且会返回应用上下文中的bean实例
     *
     * @return
     */
    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }
}
