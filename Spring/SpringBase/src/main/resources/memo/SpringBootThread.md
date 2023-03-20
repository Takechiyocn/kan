## SpringBoot

### SpringBoot的web请求

SpringBoot Web层基于servlet，servlet的每个request是一个线程

### SpringBoot同时处理请求数量

SpringBoot默认内嵌容器Tomcat，即SpringBoot处理请求数量是指内嵌Tomcat能处理的请求数量

Tomcat默认配置方法：

1. JSON配置文件

    spring-configuration-metadata.json

2. 类配置

   org.springframework.boot.autoconfigure.web.ServerProperties

Tomcat请求相关参数

1. server.tomcat.threads.min-spare：最少工作线程数，默认10

    如果并发请求数量达不到10，则依次使用这几个线程去处理请求
   
2. server.tomcat.threads.max：最多工作线程数，默认200

   如果并发请求数量在10~200之间，则依次使用这几个线程去处理请求
   
3. server.tomcat.max-connections：最大连接数，默认8192

    表示Tomcat可以处理的最大请求数量，超过8192的请求会被放入到等待队列中
   
4. server.tomcat.accept-count：等待队列长度，默认100

结论：

1. SpringBoot同时能处理的最大请求数量是:max-connections+accept-count

2. 并发请求数量低于threads.max(200)，则会立即被处理；超过部分先进行等待

3. 并发请求数量超max-connections+accept-count，超过部分被直接丢弃

### SpringBoot线程池

1. 使用ThreadPoolExecutor

2. 使用ThreadPoolTaskExecutor

   如果没有配置线程池的话，SpringBoot会自动配置一个ThreadPoolTaskExecutor线程池到bean当中

   配置方式：

   1. 主动配置步骤：
   
      1. Application启动类上添加@EnableAsync
   
      2. 在需要异步执行的方法上添加@Async
   
   2. 直接注入ThreadPoolTaskExecutor
   
   3. 直接注入ExecutorService
   
3. 自定义线程池

   1. ThreadPoolExecutor
   
   2. ThreadPoolTaskExecutor
   
   3. 实现AsyncConfigurer接口并重写getAsyncExecutor方法，该实现会覆盖SpringBoot自带的异步线程池
   


