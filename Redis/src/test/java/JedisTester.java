import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import util.JedisPoolUtil;
import util.JedisUtil;

public class JedisTester {
    // simple日志工具
    private Logger logger = LoggerFactory.getLogger(JedisTester.class);

    /**
     * 直连Redis：每次使用缓存都生成一个Jedis对象
     */
    @Test
    public void testJedis() {
        // 1. 生成一个jedis对象，负责和指定Redis节点进行通信
        Jedis jedis = new Jedis("localhost", 6379);
        // 如果需要密码
//        jedis.auth("123456");

        // 2. jedis存入数据
        jedis.del("hello", "world");
        // 3. jedis获取数据
        String value = jedis.get("hello");

        logger.info("从缓存中获取数据：" + value);
    }

    /**
     * Redis连接池JedisPool
     */
    @Test
    public void testJedisPool() {
        // 1. 获得连接池配置，并设置配置项
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大空闲数
        poolConfig.setMaxIdle(50);
        // 最大连接数
        poolConfig.setMaxTotal(100);
        // 最大等待毫秒数
        poolConfig.setMaxWaitMillis(10 * 2000);

        // 2. 初始化Jedis连接池，通常JedisPool应该是单例的
        JedisPool pool = new JedisPool(poolConfig, "localhost", 6379);
        Jedis jedis = null;
        try {
            // 从连接池获取单个连接
            jedis = pool.getResource();
            jedis.set("name", "moku");
            String str = jedis.get("name");
            logger.info("RedisPool使用：" + str);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                // 关闭连接
                jedis.close();
            }
        }

        // 3. 虚拟机关闭时，释放pool资源
        if (pool != null) {
            pool.close();
        }
    }

    @Test
    public void testJedisPoolUtil() {
        JedisPool pool = JedisPoolUtil.getJedisPoolInstance();
        JedisPool A = JedisPoolUtil.getJedisPoolInstance();
        JedisPool B = JedisPoolUtil.getJedisPoolInstance();
        logger.info("单例测试，A=B：" + (A == B));

        Jedis jedis = null;
        try {
            // 获取jedis连接对象
            jedis = pool.getResource();
            String str = jedis.set("jedisPool", "1");
            logger.info("JedisPoolUtil测试" + str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Test
    public void testJediUtil() {
        Jedis jedis = null;
        try {
            // 获取jedis连接对象
            jedis = JedisUtil.getJedis();
            jedis.set("JedisUtil", "1");
            String str = jedis.get("JedisUtil");
            logger.info("JedisUtil测试：" + str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JedisUtil.close(jedis);
        }
    }
}
