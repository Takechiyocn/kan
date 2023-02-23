## 应用架构

### CAP定理/原则

分布式系统中，三者不可兼得

1. Consistency一致性

    分布式系统中的所有数据备份，在同一时刻是否时同样的值

2. Availability可用性

    集群中一部分节点故障后，集群整体是否还能响应客户端的读写请求：对数据更新具备高可用性

3. Partition tolerance分区容错性

    分区相当于对通信的时限要求。系统如果不能在时限内达成数据一致性，就意味着发生了分区，必须就当前操作在C和A之间作出选择

### 应用架构类型

1. 单体应用：JSP+JavaBean
2. 基于MVC三层架构
3. 分布式架构开发
4. 基于SOA(面向服务编程)架构开发
5. 微服务开发
    
    1. Dubbo：半自动
    
       服务治理开发框架：一般和Zookeeper注册中心联合使用
    
       当当扩展后：Dubbox+Zookeeper
    
    2. SpringCloud：提供一站式微服务架构，全自动
    
#### 注册中心

1. Zookeeper

    保证CP原则，可用性降低

2. Eureka

    1. 保证AP原则，一致性降低
   
    2. 集群节点对等，地位相同
    
    3. 通过Eureka自我保护机制和心跳检查确保微服务高可用
    
### 微服务

定义

1. 一种架构风格，将单一应用程序划分为一组小的服务，每个服务运行在其独立的进程中，服务间小胡协调、配合

2. 服务间采用轻量级的通信机制(通常基于HTTP的RESTful API)

3. 每个服务围绕着具体的业务构建，能被独立的构建在生产环境

SpringBoot和SpringCloud

1. SpringBoot独立开发微服务

2. SpringCloud微服务治理框架


## SpringCloud

### SpringCloud优缺点

优点

1. 每个服务足够内聚，足够小，代码容易理解这样的能聚集一个指定的业务功能或业务需求
2. 开发简单，效率高，一个服务可能就是专一的只做一件事
3. 微服务是松耦合，由功能意义的服务，无论是开发阶段还是部署阶段都是独立的
3. 微服务能使用不同的语言开发------跨语言
4. 易于与第三方继承，微服务允许容易以灵活的方式集成自动部署，通过持续集成工具。Docker+Jenkins
5. 微服务易于被一个开发人员立即修改和维护，这样小团队能够更关注自己的工作成果，无需合作才能体现价值

缺点

1. 开发人员要处理分布式系统的复杂性
2. 多服务运维难度，随着服务数量增加，运维压力也在增大
3. 系统部署依赖
4. 服务间通信成本
5. 数据一致性
6. 系统集成测试
7. 性能监控

### 微服务组件

微服务开源解决方案，包括以下组件：

1. 注册与发现：独立部署

2. 负载均衡：作为基础设置模块，存在于每个Spring Cloud微服务提供者中

3. 配置中心：独立部署

3. 全链路监控

4. 服务网关

6. 熔断器

![SpringCloudSummary.png](images/SpringCloudSummary.png)

### 五大组件运行流程

1. Eureka注册中心：服务注册发现

    1. 服务注册
        
        只有一个服务注册到注册中心，才可能被其他服务发现并调用

    2. 服务发现

        一个服务通过注册中心发现了其他服务
   
2. 负载均衡Ribbon

    客户端维护一份从注册中心获取的Provider列表清单，根据自己配置的Provider负载均衡选择算法在客户端进行请求的分发    
   
3. 服务调用Feign

    一个服务对另一个服务进行调用
   
4. 隔离、熔断与降级

    1. 通过Hystrix的线程池去访问服务，不同的服务通过不同的线程池，实现了不同的服务调度隔离
       
    2. 如果服务出现故障，通过服务熔断，避免服务雪崩的问题
    
    3. 并且通过服务降级，保证可以手动实现服务正常功能
    
5. 网关路由

    如果前端调用后台系统，统一从网关进入，通过网关转发请求给对应的服务
   
### 五大组件

#### Eureka注册中心

Spring Cloud Eureka是Spring Cloud Netflix微服务套件的一部分，基于Netflix Eureka做了二次封装，主要完成微服务实例的自动注册和发现

Eureka服务治理体系中的角色

1. Eureka Server：服务注册中心

    功能：服务注册表维护和服务健康检查

2. Eureka Client
   
    1. 组成
       
        1. 服务提供者
    
            1. 注册中心客户端组件，功能：
    
                1. 服务提供者的服务注册、心跳续约
    
                2. 服务发现、实例缓存
    
            2. 远程客户端组件:RPC远程调用服务
    
        2. 服务消费者
    
    2. 功能
    
        1. 服务注册、心跳续约、健康状况查询
        
![SpringCloudEureka.png](images/SpringCloudEureka.png)
![SpringCloudEureka2.png](images/SpringCloudEureka2.png)

#### Ribbon

##### 负载均衡

1. 定义：将请求分摊在不同的服务器上进行处理

2. 分类
    
    1. 软负载
    
        1. 集中式LB：在服务的消费方和提供方之间使用独立的LB设施，如Nginx设施负责把访问请求通过某种策略转发至服务的提供方
        
            1. ApacheHttpServer+Tomcat搭建集群
        
            2. LVS
        
            3. Nginx+Tomcat搭建集群
        
        2. 进程式LB：将LB逻辑集成到消费方，消费方从服务注册中心获取哪些地址可用，并自己从中找出一个合适的服务器
        
            1. SpringCloud Netflix Ribbon
    
    2. 硬负载：使用均衡负载服务器
    
        ![LB.png](images/LB.png)

##### Ribbon负载均衡

1. 客户端的负载均衡开源组件，Feign组件不具备负载均衡能力，通过集成Ribbon组件实现客户端的负载均衡

2. Ribbon实现负载均衡样例：
    
    1. 微服务间的RPC远程调用
    
    2. API网关的代理请求的RPC转发调用

3. Ribbon负载均衡实现方式：

    1. 客户端以轮询实现（Ribbon默认）
       
    2. 随机方式
       
    3. 权重方式

4. Ribbon负载均衡过程
    
    1. 从Eureka Client获取Provider服务列表清单
    
    2. 通过定期IPing实例(如10s)向每个Provider发送ping，根据Provider是否响应，判断服务实例可用性
    
        1. Provider可用性发生改变，或者Provider清单中的数量和之前不一致：从注册中心更新或者重新拉去Provider服务实例清单 
        
    3. RPC请求到来时，由Ribbon的IRule负载均衡策略接口的某个实现类进行负载均衡，计算出要访问的最终Provider
    
5. 编码：微服务调用方法1

    1. pom依赖

        ```xml
        <!--添加Ribbon支持负载均衡添加如下依赖-->
        <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-ribbon</artifactId>
          <version>1.4.6.RELEASE</version>
        </dependency
        ```
       
    2. 在RestTemplate的Bean上添加@LoadBalance注解

#### Feign

特点

1. Feign使用了动态代理

    1. @FeignClient调用接口的本质就是调用Feign创建的动态代理
    
    2. 根据接口上的@RequestMapping等注解，动态构造出要请求的服务地址并对这个地址发起请求、解析响应

2. 使用Feign，可以做到使用HTTP请求访问远程服务，就像调用本地方法一样，开发者感知不到在调用远程方法，也感知不到在访问HTTP请求 

3. Feign整合了Ribbon和Hystrix，具备负载均衡、隔离、熔断与降级功能

编码：微服务调用方法2

1. pom依赖

    ```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-feign</artifactId>
        <version>1.4.6.RELEASE</version>
    </dependency>
    ```
   
2. API添加Client实体(自定义名字)

    ```java
    @Component
    @FeignClient(value = "DEMOSPRINGCLOUDPROVIDER-8080")
    public interface UserClient {
        @GetMapping("/get")
        List<User> get();
    }
    ```

3. 在消费者修改Controller
    
    ```java
    @Resource
    private UserClient userClient;
 
    @GetMapping("/getUser")
    public List get(){
        return userClient.get();
    }
    ```

#### Hystrix

##### 服务雪崩

* 定义：一个服务失败，导致整条链路的服务都失败的情形，称之为服务雪崩

* 引发原因

    * 硬件故障
    
    * 程序Bug
    
    * 缓存穿透(用户大量访问缓存中没有的键值，导致大量请求查询数据库，使数据库压力过大)
    
    * 用户大量请求

* 服务雪崩表现

    1. 第一阶段：服务不可用->ServiceC不可用
    
    2. 第二阶段：调用端重试加大流量(用户重试/代码逻辑重试)->
    
    3. 第三阶段：服务调者不可用(同步等待造成的资源耗尽)->ServiceA不可用
    
        ![ServiceDown.png](images/ServiceDown.png)
    
* 解决方案

    * 应用扩容(扩大服务器承受能力)：增加机器、升级硬件
    
    * 流量控制：超出限定流量后，返回类似重试页面让用户稍后再试
    
    * 服务熔断：
    
    * 服务降级：服务接口/页面拒绝服务

##### Hystrix

Hystrix是一个用于处理分布式系统的延迟和容错的开源库

功能

1. 隔离

    通过Hystrix线程池去访问服务，不同的服务通过不同的线程池，实现了不同的服务调度隔离

2. 熔断：应对雪崩效应的一种微服务链路保护机制
   
    1. 当某个服务单元发生故障之后，通过断路器的故障监控，向调用方返回一个服务预期的，可处理的备选响应(fallback)，避免服务方线程长时间被占用，从而避免服务雪崩

3. 降级：关闭不需要的微服务

    当服务不可用，客户端一直等待时，调用fallback方法给客户端返回一个错误，让其不再继续等待

    1. 服务正在等待
    
    2. 链接超时
    
    3. 网络延迟
    
    4. 服务器响应慢
    
编码

1. pom依赖

    ```xml
    <!--增加熔断机制-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-hystrix</artifactId>
        <version>1.4.6.RELEASE</version>
    </dependency>
    ```
   
2. 消费者main添加注解@EnableDiscoveryClient、@EnableCircuitBreaker

    ```java
    @SpringBootApplication
    @EnableEurekaClient
    @EnableFeignClients(basePackages = {"cn.pro.api.service"})
    @EnableDiscoveryClient
    @EnableCircuitBreaker
    public class Demo1ConsumerApplication {
        public static void main(String[] args) {
            SpringApplication.run(Demo1ConsumerApplication.class,args);
        }
    }
    ```

3. 在微服务启动类添加@EnableHystrix注解

4. 在微服务中的接口设置fallback

    ```java
    @RestController
    public class UserController {
        @GetMapping("/get")
        @HystrixCommand(fallbackMethod = "getByFallBack")
        public List<User> get() throws Exception{
            List<User> list= new ArrayList<>();
            list.add(new User(1001,"大娃",12));
            list.add(new User(1001,"大娃",12));
            list.add(new User(1001,"大娃",12));
            list.add(new User(1001,"大娃",12));
            if (list.size() != 0){
                throw new Exception("出错啦，进入雪崩");
            }
            return list;
        }
     
        public List<User> getByFallBack(){
            List<User> list= new ArrayList<>();
            list.add(new User(1001,"出错啦",12));
            list.add(new User(1001,"出错啦",12));
            list.add(new User(1001,"出错啦",12));
            list.add(new User(1001,"出错啦",12));
            return list;
        }
    }
    ```

#### Zuul

Zuul功能

1. 路由、过滤

    1. 将不同的REST请求转发至不同的微服务提供者，类似Nginx的反向代理
    
    2. 统一端口，将很多微服务提供者的不同端口统一为Zuul的服务端口

2. 认证

    1. 网关直接暴露在公网时，终端要调用某个服务，通常把登录后的token(令牌)传过来，网关层对token进行有效性验证
    
        1. token无效/没有token，不允许访问REST服务
    
        2. 实现：结合Spring Security的认证机制完成Zuul网关的安全认证

3. 限流

    1. 高并发场景下的限流 
    
4. 负载均衡

    1. 在多个微服务之间按照多种策略实现负载均衡

编码

1. pom依赖

    ```xml
    <!--  增加网关  -->
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-zuul</artifactId>
      <version>1.4.6.RELEASE</version>
    </dependency>
    ```
   
2. 启动类添加@EnableZuulProxy注解开启网关代理

    ```java
    @SpringBootApplication
    @EnableZuulProxy //开启网关代理
    public class Demo1ZuulApplication {
        public static void main(String[] args) {
            SpringApplication.run(Demo1ZuulApplication.class,args);
        }
    }
    ```

3. 在application.yml中设置

    ```xml
    server:
      port: 5050
    spring:
      application:
        name: demo1-zuul
    eureka:
      client:
        service-url:
          defaultZone: http://eureka7070:7070/eureka,http://eureka7071:7071/eureka,http://eureka7072:7072/eureka
    zuul:
      routes:
        provider8080.serviceId: DEMOSPRINGCLOUDPROVIDER-8080
        provider8080.path: /user/**
    ```
