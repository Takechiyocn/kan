## JavaWeb、Spring家族区别

### JavaWeb：单体架构

B/S：Browser/Server

Web开发三大组件：Servlet、Filter、Listener

Web开发相关技术

1. JDBC

    一个用Java语言去访问数据库的技术

2. Servlet

    servlet是运行在web服务器中的小型java程序(服务器端的小应用程序)

3. JSP

    * Java Server Pages即Java服务端页面，本质也是一个Servlet

    * 由html、Java代码、jsp标签组成，当servlet处理完数据后会转发给jsp，jsp负责显示数据
    
三大技术协同合作

1. 接收：Servlet接收浏览器发过来的请求

2. 处理：Servlet通过一些列业务的逻辑处理：查数据库用到JDBC

3. 响应：Servlet把解析完成的视图界面(HTML)返回给前端浏览器 -> 数据动态渲染

4. 浏览器显示给用户看，这就是JSP

    1. JSP：HTML+JAVA混写，页面在后端被解析，里面的Java代码被数据动态渲染完成后成为浏览器能看懂的HTML
    
    2. 再通过服务器发送给浏览器显示
    
缺点：

1. 前后端耦合严重

    1. HTML和JAVA混合模式导致前后端程序员必须知道一定的前后端知识
    
    2. 协同开发效率低
    
2. 服务器压力大
    
    1. 负责接收请求
    
    2. 负责查询数据库的业务逻辑处理
    
    3. 负责把页面渲染好并返回
    
### MVC：MVC架构

Model：负责处理业务，包括数据库的交互

Controller：负责接收请求，根据不同情况把请求转发给不同Model层业务组件租出

View：负责处理视图在后端服务器的渲染

对于单体架构而言：

* Servlet <--> Controller， 接收请求
* JDBC和一些业务类 <--> Model，处理业务逻辑
* JSP <--> View， 由后端把数据动态渲染后返回给浏览器前端显示

### Spring：微服务架构

简单而言，Spring就是管理对象的容器，核心组件是IOC容器

功能

* 事务管理

* 对象增强
  
* 自动化配置
  
* 异步调度

#### 其他框架

Struts： 取代原生的Servlet开发模式

* 原生Servlet：
  
    * 一个Servlet对应一个请求的处理。一百个Servlet对应一百个请求
    
    * 实现Servlet，必须继承HttpServlet类，重写doGet和doPost方法，对应get和post请求逻辑
    
    * Servlet对应的请求的映射还需在web.xml里面配置（Servlet3.0后支持@WebServlet注解配置请求映射）
    
* Struts

    * 使用一个配置文件管理所有的Servlet，称为Action，每个Action就是一个Servlet(需要继承ActionSupport)

Mybatis/Hibernate：取代原生的JDBC的ORM框架

早期SSH：Structs+Spring+Hibernate，前端还是JSP在服务器渲染

#### Spring生态圈扩展

之前请求

* 一个请求对应Structs中的一个Action，然后每个Action执行execute来处理请求

* 一个请求映射一个类的全类名

Spring做法：对请求的实现维度，从Servlet的类降低到方法

* 一个请求映射一个类的全类名+里面的一个方法的方法签名，提供@RequestMapping注解映射
    
    ```java
    // getUser方法，映射来自前端的user请求
    @RequestMapping("/user")
    public XXX getUser() {
    }
    ```

SSM框架：SpringMVC+Spring+MyBatis

1. SSM和MVC

    1. SSM指的是三个框架的整合开发SpringMVC+Spring+MyBatis
    
    2. MVC是一种思想(Model+View+Controller)
    
    3. 在MVC思想下
    
        1. SpringMVC框架充当Controller层，用于接收和处理请求
    
            Controller包、Provider包
    
        2. Mybatis持久层和一些被Spring管理的业务类，作为Model层，负责将SpringMVC分发过来的请求，进行相应的业务处理和数据的持久化操作
    
            * Service包：业务类，使用SpringIOC管理
            * DAO包/Mapper包：使用的框架就是Mybatis、Hibernate
    
        3. JSP或者其他视图技术，作为View层
    
SSM解决的问题：

1. 服务端代码逻辑混乱：MVC思想架构可以解决

2. 各个对象难以管理(针对Servlet)：Spring的IOC统一管理

3. 原生技术开发局限性大：使用ORM等框架实现

SSM未解决的问题：

1. 后端压力大，JSP未作改变：HTML+Java混写，后端渲染后成把JSP变成一个HTML后交给前端浏览器显示

    --> 前后端分离思想产生

#### 前后端分离














