## Spring

### Keywords

* 组件
  > 负责整个应用功能的一部分，也称为bean。

* 容器container
  > 定义：由Spring提供，也称Spring应用上下文（Spring application context）,实体。
  >
  > 作用：创建和管理应用组件。
  >
  > 如何管理组件：通过依赖注入。

* 依赖注入DI(dependency injection)
  > \1. 实体/容器创建和维护所有组件并管理它们的生命周期。
  >
  > \2. 实体将bean注入到需要它们的bean中。

* 自动配置(SpringBoot Auto Configuration)
  > 自动配置≈自动装配+组件扫描

* 自动装配autowiring
  > Spring能够自动为组件注入它们所依赖的其他bean。

* 组件扫描component scanning
  > Spring能够自动发现应用路径下的组件，并将它们创建成Spring应用上下文中的bean。
 
* 控制器controller
  > Spring MVC核心，填充可选的数据模型并将请求传递给一个视图，以便于生成返回给浏览器的HTML。

* 模板引擎
  > Thymeleaf
  > Vue

### 依赖注入方式

* XML配置
* Java配置
* 自动配置

### 注解

* @Configuration注解
  > 配置类，为容器提供bean。
  >
  > 配置类中方法用@Bean注解进行标注，表明方法返回的对象会以bean的形式添加到容器中
  > （默认bean ID与方法名称相同）。

* @Bean注解
  > bean组件。

* @SpringBootConfiguration注解
  > 声明该类为配置类。属于@Configuration注解的特殊形式。
  
* @EnableAutoConfiguration注解
  > 启用Spring Boot的自动配置。
  
* @ComponentScan注解
  > 启用组件扫描。 

* @SpringBootApplication
  > Spring Boot应用。该注解为组合注解。包含：
  > * @SpringBootConfiguration注解
  > * @EnableAutoConfiguration注解
  > * @ComponentScan注解

* @Component注解
  > 让组件扫描将类识别为一个组件，并创建该类实例作为Spring上下文中的bean。
  
* @Controller注解 
  > 让组件扫描将类识别为一个组件，并创建该类实例作为Spring上下文中的bean。

* @Service注解 
  > 让组件扫描将类识别为一个组件，并创建该类实例作为Spring上下文中的bean。

* @Repository注解
  > 让组件扫描将类识别为一个组件，并创建该类实例作为Spring上下文中的bean。

* @RunWith(测试运行器)注解
  > JUnit注解。提供一个测试运行器来指导JUnit如何运行测试。
  > 
  > sample：@RunWith(SpringRunner.class)，Spring提供测试运行器，将创建测试运行时所需的Spring应用上下文。
  > > SpringJUnit4ClassRunner:SpringRunner全称。别称SpringRunner于Spring4.3引入，
  > > 以便于移除对特定JUnit版本的关联(如JUnit4)
  > 适用于JUnit4。

* @SpringBootTest注解
  > 告诉JUnit在启动测试时要添加上Spring Boot的功能
  > 
  > 包含@ExtendWith(SpringExtension.class)用于支持JUnit5，
  > 但Sprint Boot2.1.x后SpringBootTest注解包含ExtendWith注解，
  > 即Spring Boot2.1.x后使用JUnit时不再需要ExtendWith注解

* @GetMapping(URL)注解
  > 表明如果针对URL返送HTTP GET请求，被注解的方法将会处理请求。



** 构造型注解：stereotype 
@Repository:Spring组件扫描ComponentScan会自动发现类并将其初始化为Spring应用上下文中的bean，
创建bean时，会通过@Autowired标注的构造器将JdbcTemplate注入进来 @Controller @Component

@SessionAttribute @ModelAttribute

4716442903549583

JDBC：Java Database connectivity JPA：Java Persistence API持久层API Spring Data JPA：基于关系型数据库进行JPA持久化

