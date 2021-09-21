package com.tacos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/9 23:40
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 鉴权
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 403对应：Spring Security默认开起了CSRF保护，关闭h2相关的CSRF设置
        http.csrf().ignoringAntMatchers("/h2-console/**");
        // 空白原因：Spring Security 默认页面不允许 iframe （不安全），会在响应头返回。
        // 空白对应1：允许同源访问。
        http.headers().frameOptions().sameOrigin();
        // 空白对应2：禁用frameOptions()
//        http.headers().frameOptions().disable();
        http
                .authorizeRequests()
                // 声明在前的安全规则具有更高的优先级
//                .antMatchers("/design", "/orders")
//                .access("hasRole('ROLE_USER')")
//                .access("hasRole('ROLE_USER') &&" +
//                        // 只允许具备ROLE_USER权限的用户在星期二创建新taco
//                        "T(java.util.Calendar).getInstance().get(" +
//                        "T(java.util.Calendar).DAY_OF_WEEK) == " +
//                        "T(java.util.Calendar).TUESDAY")
                .antMatchers("/", "/**").access("permitAll")
                // 新的配置区域filter：当前一个filter失败时，保存状态，继续执行下一个filter
                // and 方法表示已经完成了授权相关配置，并且要添加一些其他http配置
                .and()
                .formLogin()
                .loginPage("/login")
                // 用户登录成功后页面
                .defaultSuccessUrl("/design")
                // 新的配置区域filter：当前一个filter失败时，保存状态，继续执行下一个filter
                .and()
                // 搭建安全过滤器
                .logout()
                // 退出应用时页面（默认重定向到登陆页面）
                .logoutSuccessUrl("/")
                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**")
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
                ;
    }

    /**
     * 登录授权
     *
     * @param auth
     * @throws Exception
     */
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
