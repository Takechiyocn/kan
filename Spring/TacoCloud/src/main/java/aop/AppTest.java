package aop;

import aop.config.AppConfig;
import aop.entities.Boy;
import aop.entities.Girl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Boy boy = context.getBean("boy", Boy.class);
        Girl girl = (Girl) context.getBean("girl");
        boy.buy();
        girl.buy();
    }
}
