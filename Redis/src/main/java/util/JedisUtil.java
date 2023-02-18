package util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @ClassName JedisUtil
 * @Description Jedis工具类:从配置文件jedis.properties中读取JedisPoolConfig信息生成JedisPool,然后从连接池获取jedis对象进行缓存存取操作
 * @Author moku
 * @Date 2023/2/19 0:39
 * @Version 1.0
 */
public final class JedisUtil {

    private static String host;
    private static int port;
    private static int maxtotal;
    private static int maxidel;
    private static int maxwaitmillis;

    private JedisUtil() {
    }

    private static volatile JedisPool jedisPool = null;


    /**
     *  static静态块的代码主要用于类的初始化。在虚拟机加载类的时候就会加载执行，而且只执行一次，会在项目main函数之前执行。
     *  1、读取jedis.properties配置文件
     */
    static {
        ResourceBundle rb = ResourceBundle.getBundle("jedis");
        host = rb.getString("host");
        port = Integer.parseInt(rb.getString("port"));
        maxtotal = Integer.parseInt(rb.getString("maxtotal"));
        maxidel = Integer.parseInt(rb.getString("maxidel"));
        maxwaitmillis = Integer.parseInt(rb.getString("maxwaitmillis"));
    }

    /**
     * 一个类中可以定义多个静态代码块，按顺序执行
     *  2、创建单例连接池
     */
    static {
        if (jedisPool == null) {
            synchronized (JedisPoolUtil.class) {
                if (jedisPool == null) {

                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    // 最大连接数
                    poolConfig.setMaxTotal(maxtotal);
                    // 最大空闲连接数
                    poolConfig.setMaxIdle(maxidel);
                    // 最大等待时间
                    poolConfig.setMaxWaitMillis(maxwaitmillis);
                    // 检查连接可用性, 确保获取的redis实例可用
                    poolConfig.setTestOnBorrow(true);

                    jedisPool = new JedisPool(poolConfig, host, port);
                }
            }
        }
    }

    /**
     * 3、获取jedis
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * * 4、将Jedis对象（连接）归还连接池
     */
    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}