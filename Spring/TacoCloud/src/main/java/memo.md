        // 组件扫描component scanning：发现应用类路径下的组件，并将其创建成上下文中的bean
        // 自动装配autowiring：为组件注入他们所依赖的bean
        // 自动配置autoconfiguration：
        //   基于应用类路径中的条目
        //   环境变量
        //   其他因素
        //   合理猜测需要配置的组件并进行封装

** 构造型注解：stereotype
 @Repository:Spring组件扫描ComponentScan会自动发现类并将其初始化为Spring应用上下文中的bean，
             创建bean时，会通过@Autowired标注的构造器将JdbcTemplate注入进来
 @Controller
 @Component

 @SessionAttribute
 @ModelAttribute

 4716442903549583

 JDBC：Java Database connectivity
 JPA：Java Persistence API持久层API
 Spring Data JPA：基于关系型数据库进行JPA持久化

