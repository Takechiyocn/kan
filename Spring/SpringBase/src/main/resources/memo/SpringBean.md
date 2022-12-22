## Bean如何注册到Spring

![BeanRegistration.png](images/BeanRegistration.png)

### 过程

1. 类无法调用没有实现的接口，可通过代理给接口生成对应的实现类

2. 将代理类放到Spring的FactoryBean的实现中

3. 把这个FactoryBean实现类注册到Spring容器

4. 代理类已经注册到Spring容器，之后可通过注解的方式注入到属性中

