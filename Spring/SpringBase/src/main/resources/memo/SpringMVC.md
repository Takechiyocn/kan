## Spring MVC

### Spring MVC初始化

![SpringContainerInitialization.png](images/SpringContainerInitialization.png)

#### 处理流程

1. 初始化处理
   
    1. Web容器启动通知Spring初始化容器，加载Bean的定义信息并初始化所有单例Bean
       
    2. 遍历容器中的Bean，获取每一个Controller中所有方法访问的URL，将URL和所有对应的Controller保存到Map集合(HandlerMapping)中
    
2. 请求处理(生成处理器执行链)
   
    1. 所有请求转发给前端处理器DispatcherServlet处理
       
    2. DispatcherServlet请求HandlerMapping找出被@Controller注解修饰的Bean和被@RequestMapping修饰的方法和类
       
       * Controller中可调用一些Service和DAO进行数据操作
       
    3. 生成Handler和HandlerInterceptor并以一个HandlerExecutionChain处理器执行链返回
    
3. 执行处理(获取ModelAndView)
   
    1. DispatcherServlet使用Handler找到HandlerAdapter并执行业务前相应处理(表单验证、数据类型转换)
       
    2. 通过HandlerAdapter调用Handler方法
       
    3. 将请求参数绑定到方法的形参上，执行方法处理请求并得到逻辑视图ModelAndView
    
4. 视图解析
   
    1. DispatcherServlet使用视图解析器ViewResolver对ModelAndView进行解析，得到View物理视图
       
    2. 对视图渲染并填充数据到视图中
       
    3. 返回客户端

#### Spring MVC组件

* DispatcherServlet
    
    前端控制器，整个控制流程核心，负责接受请求并转发给对应的处理器组件
  
* Handler

    处理器，完成具体业务逻辑，相当于Servlet和Action
  
* HandlerMapping

    完成URL到Controller的映射，DispatcherServlet通过HandlerMapping将不同请求映射到不同Handler
  
* HandlerInterceptor

    处理拦截器(接口)，如果需要可实现该接口完成一些拦截处理
  
* HandlerExecutionCharin

    处理器执行链，包括Handler和HandlerInterceptor
  
* HandlerAdapter
    
    处理器适配器，Handler执行业务前需要进行的一系列操作
  
    包括：表单数据验证，数据类型转换，将表单数据封装到JavaBean
  
    DispatcherServlet通过HandlerAdapter执行不同Handler
  
* ModelAndView

    装载模型数据和视图信息，Handler处理结果并返回给DispatcherServlet
  
* ViewResolver

    视图解析器，DispatcherServlet通过ViewResolver将逻辑视图解析为物理视图，将渲染结果响应给客户端
  
### Spring MVC注解

* @Controller

    类定义处添加，将类交给IoC容器管理

* @RequestMapping

  映射URL请求和业务方法，类和方法定义上都可添加

  参数：
    * value：URL请求的实际地址
    * method：请求方法类型
        * GET
        * POST
        * PUT
        * DELETE
    * params：限制必须提供的参数

* @RequestParam

    Controller方法的形参和URL参数名不一致可使用该注解绑定(一致时可不使用)

    参数：
    * value：HTTP请求中的参数名
    * required：参数是否必要，默认false
    * defaultValue：没有给参数赋值时的默认值

* @PathVariable

    RESTful风格URL，通过@PathVariable完成请求参数与形参的绑定

### AOP(Aspect Orient Programming)

面向切面编程，简单说就是将重复代码提取出来，在需要执行的时候使用动态代理技术，在不修改源码的基础上对源码进行增强

![SpringAOP.png](images/SpringAOP.png)

#### AOP分类

JDK动态代理：类实现接口时使用
    
CGLib动态代理：类未实现接口时使用，在运行时动态生成某个类的子类，final标记的类不能使用

#### AOP注解

* @Aspect

    被注解的类是一个切面Bean

* @Before
  
    前置通知，在某个连接点之前执行的通知
  
* @After
  
    后置通知，某个连接点退出时执行的通知(正常退出/异常退出均执行)
  
* @AfterReturning
  
    返回后通知，某个连接点正常执行后执行的通知，returning属性接收返回值
  
* @AfterThrowing

    异常通知，方法抛出异常导致退出时执行的通知，throwing属性接收返回值

    和@AfterReturning只会有一个执行

![SpringAOPAdviceNormal.png](images/SpringAOPAdviceNormal.png)

![SpringAOPAdviceUnNormal.png](images/SpringAOPAdviceUnNormal.png)

#### AOP相关术语

* Aspect

    切面，一个关注点的模块化，这个关注点会横切多个对象

    切入点+通知

* JoinPoint

    连接点，程序执行过程中的某一行为，即业务层中的所有方法

* Advice

    通知，切面对于某个连接点所产生的动作，包括前置通知、后置通知、返回后通知、异常通知和环绕通知

* PointCut

    切入点，指被拦截的连接，切入点一定是连接点，连接点不一定是切入点

* Proxy
    
    代理，Spring AOP有JDK动态代理和CGLib代理

* Target

    代理的目标对象，指一个或多个切面通知的对象

* Weaving

    织入，指把增强/通知advice应用到目标对象target来创建代理对象proxy的过程

  ![SpringAOPConcept.png](images/SpringAOPConcept.png)

### IOC(Inversion of Control控制反转)

    传统创建对象：new关键字创建
    Spring创建对象：通过IOC容器创建，即将创建对象的控制权交给了IOC容器
    优点：IOC让程序员不再关注如何创建对象，而关注创建对象后的操作，把对象的创建、初始化、销毁等工作交给Spring容器
    通俗理解，对于某个具体对象而言，传统是它控制其他对象，现在是所有对象都被Spring控制，称控制反转

#### BeanFactory

Spring基础设施，面向Spring本身

![SpringBeanFactory.png](images/SpringBeanFactory.png)

##### HierarchicalBeanFactor父子级联

子容器可以通过接口(HierarchicalBeanFactor父子级联)访问父容器的bean，父容器不能访问子容器的bean

如：SpringMVC

* 视图层Bean：子容器中

* 业务层/持久层Bean：父容器中

* 视图层Bean可以引用业务层和持久层Bean，反之则不行

#### ApplicationContext

面向开发者

![SpringApplicationContext.png](images/SpringApplicationContext.png)

1. ClassPathXmlApplicationContext：默认从类路径加载配置文件

2. FileSystemXmlApplicationContext：默认从文件系统中装载配置文件
   
3. ApplicationEventPublisher：让容器拥有发布应用上下文事件的功能，包括容器启动事
   件、关闭事件等。
4. MessageSource：为应用提供 i18n 国际化消息访问的功能；
   
5. ResourcePatternResolver ： 所 有 ApplicationContext 实现类都实现了类似于
   PathMatchingResourcePatternResolver 的功能，可以通过带前缀的 Ant 风格的资源文
   件路径装载 Spring 的配置文件。
   
6. LifeCycle：该接口是 Spring 2.0 加入的，该接口提供了 start()和 stop()两个方法，主要
   用于控制异步处理过程。在具体使用时，该接口同时被 ApplicationContext 实现及具体
   Bean 实现， ApplicationContext 会将 start/stop 的信息传递给容器中所有实现了该接
   口的 Bean，以达到管理和控制 JMX、任务调度等目的。
   
7. ConfigurableApplicationContext 扩展于 ApplicationContext，它新增加了两个主要
   的方法： refresh()和 close()，让 ApplicationContext 具有启动、刷新和关闭应用上下
   文的能力。在应用上下文关闭的情况下调用 refresh()即可启动应用上下文，在已经启动
   的状态下，调用 refresh()则清除缓存并重新装载配置信息，而调用close()则可关闭应用
   上下文。

#### WebApplication

面向Web应用，允许从相对于web根目录路径装载配置文件完进行初始化

* ServletContext：存放Web应用上下文对象(作为属性)
  
* WebApplicationContext：可获取ServletContext的引用

* Web应用环境可以访问Spring应用上下文

![SpringWebApplicationContext.png](images/SpringWebApplicationContext.png)

### DI(Dependency Injection依赖注入)

    Spring通过DI动态的向某个对象提供其他所需要的对象(通过反射实现)

### Spring Bean作用域

![SpringBeanScope.png](images/SpringBeanScope.png)

#### 单例模式singleton(默认作用域:全局共享)

SpringIoC容器只存在一个共享的Bean实例
 
```java
<bean id="userDao" class="com.ioc.UserDaoImpl" scope="singleton"/>
```

#### prototype原型模式(创建后IoC容器不再管理bean状态)

* 每次获取bean时，容器创建新bean实例
  
* xml配置时，Spring启动时不创建实例，类似lazy-init

* 有状态的bean使用prototype，无状态bean使用singleton

场景：

#### request：请求作用域

每一次HTTP请求都会创建一个新的bean，该bean仅在当前Http Request内有效，请求处理完后销毁实例(请求和响应共享bean)

场景：一次Http请求和响应的共享Bean

```java
<bean id="loginAction" class="" scope="request"/>
```

#### session：会话作用域

同一Http Session之间共享一个bean，不同session(会话)使用不同bean

场景：记录用户的登录信息

```java
<bean id="user" class="" scope="session"/>
```

解读

    1. 设置bean id = user
    2. Spring容器每次调用user时，都会在(每)一个会话中创建一个新实例(因为bean是session级别)
    3. session中所有请求(request)共享一个bean
    4. 会话级别的bean可随意修改互不影响 

#### ~~global session：全局会话作用域~~

全局session作用域，仅在基于portlet的web应用中才有意义

* portlet时能够生成语义代码(如HTML)片段的小型JavaWeb插件(Spring5已取消该功能)

* portlet与servlet不同，每个portlet都有不同的会话

#### application：全局作用域

ServletContext级别：在一个Http Servlet Context中，定义一个Bean实例

场景：Web应用的上下文信息，比如：记录一个应用的共享信息

```java
<bean id="app" class="" scope="application"/>
```

#### singleton和application区别

* singleton是Spring Core的作用域，作用于IoC的容器
  
* application是Spring Web中的作用，作用于Servlet容器

#### Spring的Controller是单例

单例线程不安全，可能导致属性重复使用

解决方案：

* 不在Controller中定义成员变量

* 必须定义非静态成员变量时，通过注解@Scope("request")，将其设置为多例模式


### Spring Bean声明周期