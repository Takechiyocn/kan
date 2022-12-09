package moku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

// 启动类要加上一个注解开启缓存
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@EnableCaching
public class LettuceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LettuceApplication.class, args);
    }
}
