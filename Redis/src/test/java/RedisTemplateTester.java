import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName RedisTemplateTester
 * @Description
 * @Author moku
 * @Date 2023/2/19 1:00
 * @Version 1.0
 */
public class RedisTemplateTester {

    // simple日志工具
    private Logger logger = LoggerFactory.getLogger(JedisTester.class);

    ApplicationContext context =
            new ClassPathXmlApplicationContext("JedisPoolConfig.xml");

    // 自带的字符串模板，用于存储字符串
    // 直接使用RedisTemplate获取连接池中的连接
    @Autowired
    private StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) context.getBean("stringRedisTemplate");


    // 自带的字符串模板，用于存储对象
    @Autowired
    private RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");

    @Test
    public void testStringRedisTemplate() {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("StringRedisTemplate", "1");
        String str = stringRedisTemplate.opsForValue().get("StringRedisTemplate");
        logger.info("StringRedisTemplate测试：" + str);
    }

    @Test
    public void testRedisTemplate() {
        Student student = new Student();
        student.setName("name");
        student.setAge(20);

        redisTemplate.opsForValue().set("student3", student);
        Student student3 = (Student) redisTemplate.opsForValue().get("student3");
        logger.info("Student3:" + student3.getName());
    }
}
