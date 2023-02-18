## Jedis和RedisTemplate

### Jedis

* Jedis是Redis的Java连接开发工具，提供了很多接口供Java调用

* 直连redis server，多线程环境下非线程安全，除非使用线程池JedisPool为每个Jedis实例增加物理连接

### Spring Data Redis模块

* Spring-data-redis是Spring家族一部分，提供了在Spring中通过简单的连接池配置访问redis服务

* 对Redis底层开发包(Jedis、JRedis等)进行高度封装

* 其中的RedisTemplate提供了redis各种操作
  
    * 异常处理
      
    * 序列化
    
    * 支持发布订阅
    
    * 对Spring3.1cache进行了实现
    
    * 支持对象缓存操作
    
功能

1. 连接池自动管理，提供了一个高度封装的RedisTemplate类

2. 针对Jedis客户端中大量api进行了归类封装,将同一类型操作封装为operation接口

    * ValueOperations：简单K-V操作

    * HashOperations：针对map类型的数据操作

    * ListOperations：针对list类型的数据操作
   
    * SetOperations：set类型数据操作

    * ZSetOperations：zset类型数据操作

### SpringBoot2.0

使用lettuce代替jedis：多线程安全、异步和响应使用

### 多线程场景下使用

1. 以前

    Jedis+JedisPool组合

2. 现在

    * SpringBoot2.0中直接使用lettuce客户端的API封装RedisTemplate即可

    * 配置好连接池属性，SpringBoot就能自动管理连接池
    

