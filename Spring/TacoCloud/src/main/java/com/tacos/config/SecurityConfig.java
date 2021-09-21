package com.tacos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/8 12:25
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 1.基于内存的用户存储
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                // 新版本内存用户需要提供密码编码器passwordEncoder
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("buzz")
                .password("buzz")
                .roles("USER")
                .authorities("SUPERADMIN")
                .and()
                .withUser("woody")
                .password("woody")
                .authorities("ROLE_USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // H2本地无法访问对应：设置同源访问。
        http.headers().frameOptions().sameOrigin();
        http.authorizeRequests()
                .antMatchers("/orders").permitAll()
//                .antMatchers("/design","/orders/current").hasRole("USER") //访问 /user这个接口，需要有USER角色
//                .anyRequest().authenticated() //剩余的其他接口，登录之后就能访问
                .and().httpBasic()
                .and().csrf().disable()
//                .and()
//                .formLogin().defaultSuccessUrl("/hello")
        ;
    }

    /**
     * 2.基于JDBC的用户存储
     *   数据库端密码非明文保存
     *   用户登录时密码会按照相同算法进行转码，再与数据库中已经转码过的密码通过PasswordEncoder的matches方法对比
     *
     * @param auth
     * @throws Exception
     */
//    @Autowired
//    DataSource dataSource;
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                // 用户认证：重写认证查询：获取用户的用户名、密码以及是否启用的信息
//                .usersByUsernameQuery(
//                        "select username, password, enabled from Users" +
//                                "where username=?")
//                // 鉴权：重写基本权限查询：查找用户所授予的权限
//                .authoritiesByUsernameQuery(
//                        "select username, authority from UserAuthorities " +
//                                "where username=?")
//                // 重写群组权限查询：查找用户作为群组的成员所授予的权限
//                .groupAuthoritiesByUsername(
//                        "select g.id, g.group_name, ga.authority " +
//                                "from groups g, group_members gm, group_authorities ga " +
//                                "where gm.username = ? " +
//                                "and g.id = ga.group_id " +
//                                "and g.id = gm.group_id")
//                // •BCryptPasswordEncoder：使用bcrypt强哈希加密。
//                // •NoOpPasswordEncoder：不进行任何转码。
//                // •Pbkdf2PasswordEncoder：使用PBKDF2加密。
//                // •SCryptPasswordEncoder：使用scrypt哈希加密。
//                // •StandardPasswordEncoder：使用SHA-256哈希加密。
//                .passwordEncoder(new BCryptPasswordEncoder(512));
//    }

    /**
     * 3.以LDAP作为后端的用户存储
     *  LDAP认证默认策略：进行绑定操作，直接通过LDAP服务器认证用户
     *  用户可选策略：进行对比操作，即将输入的密码返送到LDAP服务器，
     *              并要求服务器将这个密码与用户的密码进行对比(对比在LDAP服务器内完成)
     *              登录表单提供的密码与默认的LDAP条目对比：userPassword属性
     *              可通过passwordAttribute()方法声明对比条目
     *  spring Security的LDAP认证默认LDAP服务器监听本机的33389端口，可使用contextSource()方法配置该地址
     *
     * @param auth
     * @throws Exception
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .ldapAuthentication()
//                // 为查找用户提供基础查询，即声明用户应该在名为people的组织单元下搜索
//                .userSearchBase("ou=people")
//                // 默认从根(单元)开始搜索
//                .userSearchFilter("(uid={0})")
//                // 为查找组提供基础查询，即声明组应该在名为groups的组织单元下搜索
//                .groupSearchBase("ou=groups")
//                // 默认从根(单元)开始搜索
//                .groupSearchFilter("member={0}")
//                // 使用LDAP密码对比（默认：登录表单提供的密码与用户的LDAP条目中userPassword属性对比）
//                .passwordCompare()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                // 重新设置对比属性
//                .passwordAttribute("passcode")
//                // 默认LDAP服务器监听本机33389端口
//                // 配置新的LDAP服务器地址
////                .contextSource()
////                .url("ldap://tacocloud.com:389/dc=tacocloud,dc=com")
//                // 嵌入式LDAP服务器：root指定嵌入式服务器的根前缀
//                //   LDIF：LDAP Data Interchange Format-> LDAP数据交换格式
//                //   LDAP服务器从类/根路径下寻找LDIF，可通过ldif()方法指定加载哪个LDIF文件
//                .contextSource()
//                .root("dc=tacocloud,dc=com")
//                // 指定加载ldif文件
//                .ldif("classpath:user.ldif")
//        ;
//    }

    // 4. 自定义用户认证
    //  见TacoCloud-JPA
}
