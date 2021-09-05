package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 组合注解
// SpringBootConfiguration注解：声明配置类，Configuration的特殊形式
// EnableAutoConfiguration注解：启用Spring Boot自动配置
// ComponentScan注解：启用组件扫描
public class TacoCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }
}
