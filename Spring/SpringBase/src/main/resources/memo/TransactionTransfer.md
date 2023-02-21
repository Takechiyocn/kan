## Spring事务传播

事务传播传递的是一个Connection，Spring事务说到底底层是对jdbc的封装

隔离级别针对不同Connection，而传播行为基于一个Connection，设置不同的savepoint

### 分布式事务

分布式事务指的是事务的参与者、支持事务的服务器、资源服务器以及事务管理器分别位于不同的分布式系统的节点上

### 事务类型

* 手动事务

    如果选择手动控制分布式事务，则必须管理恢复、并发、安全性和完整性，即必须维护与事务处理关联的ACID属性所需要的所有编程方法

* 自动事务

    自动控制事务范围

### Spring事务分类

* 编程式事务

    * 通过代码方式使用事务
    
        通过TransactionTemplate/PlatformTransactionManager手动控制事务的提交、回滚
    
    * 接口
    
        * TransactionDefinition：定义了Spring兼容的事务属性(比如事务隔离级别、事务传播、事务超时、是否只读状态)
    
        * TransactionStatus：代表事务的具体运行状态(获取事务运行状态的信息，也可通过该接口间接回滚事务等操作)
    
        * PlatformTransactionManager：事务管理器接口(定义了一组行为，具体实现交由不同的持久化框架完成，类比JDBC)

    * 特点
    
        * 对代码的侵入性小
        
        * 事务的管控粒度较细，可以实现代码块级别的事务
    
* 声明式事务

    * 通过配置方式使用事务
    
        @Transaction注解
    
    * 接口

        * TransactionDefinition：定义了Spring兼容的事务属性(比如事务隔离级别、事务传播、事务超时、是否只读状态)

        * TransactionStatus：代表事务的具体运行状态(获取事务运行状态的信息，也可通过该接口间接回滚事务等操作)

        * PlatformTransactionManager：事务管理器接口(定义了一组行为，具体实现交由不同的持久化框架完成，类比JDBC)    
    
        * TransactionProxyFactoryBean：生成代理对象
    
        * TransactionInterceptor：实现对象的拦截
    
        * TransactionAttribute：事务配置的数据

### Spring事务实现

由AOP实现，通过事务拦截器TransactionInterceptor开启事务、管理事务、等业务操作完成后进行commit或者rollback

### Spring线程Connection独立

Spring通过TransactionSynchronizationManager来保证事务获取同一Connection，同一时刻我们每个线程持有的Connection是独立且互不干扰和互不相同

底层由ThreadLocal线程本地变量来为不同事务提供独立的资源副本

### 事务传播

事务：逻辑上的一组操作，组成这个操作的各个逻辑单元要么全部成功，要么全部失败

当多个事务同时存在时，Spring如何处理这些事务的行为：通常在@Transaction注解中设置

Spring事务传播机制(比如方法A调用方法B)

1. 支持当前事务

    * PROPAGATION_REQUIRED(Spring默认事务传播类型)
    
        * 如果当前存在事务，则加入这个事务
    
            A中存在SQL操作，A和B变成一个事务，同时成功、失败        
          
        * 如果当前没有事务，则自己新建一个事务(A中没有事务，B新建事务)
    
    * PROPAGATION_SUPPORTS：辅助，跟着A变化
    
        * 如果当前存在事务，则加入这个事务
    
            A和B变成一个事务，同时成功、失败
    
        * 如果当前没有事务，(B)以非事务方式执行：都不用事务
    
    * PROPAGATION_MANDATORY：强制，必须使用事务
    
        * 如果当前存在事务，则加入这个事务
    
            A和B变成一个事务，同时成功、失败
    
        * 如果当前没有事务，则抛出异常
    
    ※ 当前：调用方A
    
    ※ 自己：被调用方B

2. 不支持当前事务

    * PROPAGATION_REQUIRES_NEW
    
        * 创建一个新的事务，如果当前存在事务，则挂起当前事务
        
            方法B新建事务，A和B事务各自提交、回滚
      
    * PROPAGATION_NOT_SUPPORT
    
        * 以非事务方式执行，如果当前存在事务，则挂起当前事务
        
            B一定以非事务方式执行
      
    * PROPAGATION_NEVER
    
        * A和B以非事务方式执行
          
        * 如果当前存在事务，则抛出异常，即A和B都不能有事务

3. 嵌套事务：使用回滚点实现回滚，调用B方法前会建立一个savepoint
     
    * PROPAGATION_NESTED
    
        * 如果当前存在事务，则嵌套事务执行
    
        * 如果当前没有事务，则自己新建一个事务(A中没有事务，B新建事务)
        
        * 关于回滚：下层回滚而上层不回滚最终事务视为成功，不会触发事务回滚事件
    
            * 每层事务可以设置rollbackOnly实现独立回滚，即相互不影响
    
            * 通过抛出异常回滚(还需判断A、B有无使用事务@Transaction)
          
                * A、B都使用事务
    
                    * A、B只要有一个发生异常，A和B都回滚
    
                * A使用事务，B不使用事务
    
                    * A发生异常，A和B都回滚

                    * B发生异常，若Acatch异常并且没有向上抛出异常，则A、B都不回滚

                    * B发生异常，若Acatch异常并且向上抛出异常，则A、B都回滚
            
                * A不使用事务，B使用事务
    
                    * 无论AB是否发生异常，A都不回滚
    
                    * B发生异常，B回滚
    
    * 想让所有异常都回滚：使用@Transaction(rollbackFor = Exception.class)

### Nested和Required_New区别

* Required_New新建一个事务，且与原有事务无关

* Nested当前存在事务时开启一个嵌套事务(子事务)

* 回滚

    * Required_New与原有事务无关
    
    * Nested原有事务(父事务)回滚，子事务回滚；反之不一定

### Nested和Required区别

* Required当前事务存在时，由于使用同一事务，B事务catch与否A事务都会回滚

* Nested原有事务(父事务)回滚，子事务回滚；反之不一定