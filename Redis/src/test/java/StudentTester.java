import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class StudentTester {
    @Test
    public void test() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("JedisPoolConfig.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        Student student = new Student();
        student.setName("name");
        student.setAge(20);
        redisTemplate.opsForValue().set("student-1", student);
        Student student1 = (Student) redisTemplate.opsForValue().get("student-1");
        student1.service();
    }
}
