## 实例化多个Redis

1. 通过RedisTemplate

2. 通过JedisPool

### 通过RedisTemplate

思路：配置2个RedisTemplate，并设置不同dbindex进行分开访问

```java
JedisConnectionFactory factory = new JedisConnectionFactory();
...
factory.setDatabase(databaseId);//set dbindex
```

流程：

1. RedisTemplate创建时需要传入JedisConnectionFactory实例，在该实例中指定dbindex

2. 创建JedisConnectionFactory实例时需要使用@Scope(scopeName="prototype")多例模式

3. 实例化多个JedisConnectionFactory并设置不同的dbindex(setDatabase方法)

4. 使用不同的JedisConnectionFactory实例化多个RedisTemplate

    ```java
    @Configuration
    public class LoginMacRedisConfig {
    
        private static final Logger logger = LoggerFactory.getLogger(LoginMacRedisConfig.class);
        @Value("1")
        private int logmacDatabaseId;
    
        @Value("3")
        private int mobmaskDatabaseId;
    
    
        @Bean
        public JedisPoolConfig getRedisConfig() {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(8);
            config.setMinIdle(0);
            return config;
        }
    
        // 多例JedisConnectionFactory
        @Scope(scopeName = "prototype")
        public JedisConnectionFactory jedisConnectionFactory() {
    
            JedisPoolConfig config = getRedisConfig();
            JedisConnectionFactory factory = new JedisConnectionFactory(config);
            factory.setUsePool(true);
            factory.setHostName(host);
            factory.setPort(port);
            return factory;
        }
    
        @Bean(name = "login_mac")
        public RedisTemplate<String, Map<String, String>> logmacRedisTemplate() {
            final RedisTemplate<String, Map<String, String>> template = new RedisTemplate<>();
    
            // 实例JedisConnectionFactory
            JedisConnectionFactory jedisConnectionFactory = jedisConnectionFactory();
            jedisConnectionFactory.setDatabase(logmacDatabaseId);
            template.setConnectionFactory(jedisConnectionFactory);
            logger.info("host:{}, port:{}, database:{}", jedisConnectionFactory.getHostName(),jedisConnectionFactory.getPort(), jedisConnectionFactory.getDatabase());
        
            // 使用JedisConnectionFactory实例化RedisTemplate
            StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
            template.setKeySerializer(stringRedisSerializer);
            template.setHashKeySerializer(stringRedisSerializer);
            template.setHashValueSerializer(stringRedisSerializer);
            return template;
        }
    
        @Bean(name = "mobile_mask")
        public RedisTemplate<String, Map<String, String>> mobileMaskRedisTemplate() {
            final RedisTemplate<String, Map<String, String>> template = new RedisTemplate<>();
   
            // 实例JedisConnectionFactory
            JedisConnectionFactory jedisConnectionFactory = jedisConnectionFactory();
            jedisConnectionFactory.setDatabase(mobmaskDatabaseId);
            template.setConnectionFactory(jedisConnectionFactory);
            logger.info("host:{}, port:{}, database:{}", jedisConnectionFactory.getHostName(),jedisConnectionFactory.getPort(), jedisConnectionFactory.getDatabase());
   
            // 使用JedisConnectionFactory实例化RedisTemplate
            StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
            template.setKeySerializer(stringRedisSerializer);
            template.setHashKeySerializer(stringRedisSerializer);
            template.setHashValueSerializer(stringRedisSerializer);
            return template;
        }
    }
    ```

5. service类注入不同RedisTemplate

    ```java
    @Service
    public class RedisTestService {
        @Autowired
        @Qualifier("login_mac")
        private RedisTemplate<String, Map<String, String>> template1;
    
        @Autowired
        @Qualifier("mobile_mask")
        private RedisTemplate<String, Map<String, String>> template2;
    
        public void write2Redis() {
            HashOperations<String, String, String> hashOperations = template1.opsForHash();
            Map<String, String> values = new HashMap<>();
            values.put("dbindex", "1");
            hashOperations.putAll("123", values);
        
            template2.opsForHash().put("123", "dbindex", "3");
        }
    }
    ```

### JedisPool

1. 通过JedisPool创建jedis

2. 调用select方法选择dbindex

    ```java
    @Bean
    public JedisPool redisPoolFactory() {
        JedisPool jedisPool = new JedisPool(jedisPoolConfig(), host, port);
        Jedis jedis = jedisPool.getResource();
        jedis.select(3);
        return jedisPool;
    }
    ```
   
缺点

1. 无法使用RedisTemplate各种方便接口读写Redis

### RedisConnectionCommand

1. 使用RedisConnectionCommand的select方法，也用不了RedisTemplate

    ```java
    RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
    DefaultStringRedisConnection stringRedisConnection = new   DefaultStringRedisConnection(redisConnection);
    stringRedisConnection.select(2);
    stringRedisConnection.set("test", "test");
    ```