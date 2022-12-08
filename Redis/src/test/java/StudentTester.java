import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class StudentTester {
    @Test
    public void test() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("JedisPoolConfig.xml");
        // 1. 使用IOC获取连接池内连接(连接池通过配置文件设置)
        RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
        Student student = new Student();
        student.setName("name");
        student.setAge(20);
        redisTemplate.opsForValue().set("student-1", student);
        Student student1 = (Student) redisTemplate.opsForValue().get("student-1");
        student1.service();

        // 2. 直接使用RedisTemplate获取连接池内连接(TODO：连接池如何设置？)
        RedisTemplate redisTemplate2 = context.getBean(RedisTemplate.class);
        student.setName("name2");
        student.setAge(30);
        redisTemplate2.opsForValue().set("student2", student);
    }
}
