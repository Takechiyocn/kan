package com.example.redisspringboot;

import com.entity.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class RedisSpringBootApplicationTests {
    Logger logger = LoggerFactory.getLogger(RedisSpringBootApplicationTests.class);

    @Test
    void contextLoads() {
    }

    // 使用StringRedisTemplate获取连接池内连接(连接池通过application.yml设置?)
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void testString() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("1121", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Resource
    private RedisTemplate redisTemplate;
    @Test
    public void testObject() {
        Student student = new Student();
        student.setName("moku");
        student.setAge(5);
        redisTemplate.opsForValue().set("student-1", student);
        Student student1 = (Student) redisTemplate.opsForValue().get("student-1");
        System.out.println(student1.getName());
    }

    // list数据类型适合于消息队列的场景:比如12306并发量太高，而同一时间段内只能处理指定数量的数据！
    // 必须满足先进先出的原则，其余数据处于等待
    @Test
    public void listPushResitTest() {
        // leftPush依次由右边添加
        stringRedisTemplate.opsForList().rightPush("myList", "1");
        stringRedisTemplate.opsForList().rightPush("myList", "2");
        stringRedisTemplate.opsForList().rightPush("myList", "A");
        stringRedisTemplate.opsForList().rightPush("myList", "B");
        // leftPush依次由左边添加
        stringRedisTemplate.opsForList().leftPush("myList", "0");
        
        // 查询类别所有元素
        List<String> listAll = stringRedisTemplate.opsForList().range("myList", 0, -1);
        logger.info("list all {}", listAll);
        // 查询前3个元素
        List<String> list = stringRedisTemplate.opsForList().range("myList", 0, 3);
        logger.info("list limit {}", list);

        // 删除先进入的B元素
        stringRedisTemplate.opsForList().remove("myList", 1, "B");
        listAll = stringRedisTemplate.opsForList().range("myList", 0, -1);
        logger.info("list all {}", listAll);

        // 删除所有A元素
        stringRedisTemplate.opsForList().remove("myList", 0, "A");
        listAll = stringRedisTemplate.opsForList().range("myList", 0, -1);
        logger.info("list all {}", listAll);
    }

    @Test
    public void hashPutResitTest() {
        // map的key值相同，后添加的覆盖原有的
        stringRedisTemplate.opsForHash().put("banks:12600000", "a", "b");
        stringRedisTemplate.opsForHash().put("banks:12600000", "c", "b");
    }

    @Test
    public void hashGetEntriesResitTest() {
        // 获取map对象
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("banks:12600000");
        logger.info("objects:{}", map);
    }

    @Test
    public void hashGeDeleteResitTest() {
        // 根据map的key删除这个元素
        stringRedisTemplate.opsForHash().delete("banks:12600000", "c");
    }

    @Test
    public void hashGetKeysResitTest() {
        // 获得map的key集合
        Set<Object> objects = stringRedisTemplate.opsForHash().keys("banks:12600000");
        logger.info("objects:{}", objects);
    }

    @Test
    public void hashGetValueListResitTest() {
        // 获得map的value列表
        List<Object> objects = stringRedisTemplate.opsForHash().values("banks:12600000");
        logger.info("objects:{}", objects);
    }

    @Test
    public void hashSize() { // 获取map对象大小
        long size = stringRedisTemplate.opsForHash().size("banks:12600000");
        logger.info("size:{}", size);
    }
}
