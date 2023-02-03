## Java基础知识

### 线程和线程的区别

* Point

    地址空间、开销、并发性、内存

* 标准回答

    进程和线程的主要差别在于它们是不同的操作系统资源管理方式

    区别|进程|线程
    ---|---|---
    地址空间|进程有独立的地址空间|线程有自己的堆栈和局部变量，但线程之间没有单独的地址空间
    开销|进程切换时需要切换进程的上下文，且上下文切换时间开销远大于线程，消耗资源大，效率差|线程切换时需要切换线程的上下文，切换开销较小
    并发性|进程的并发性较低|线程的并发性较高
    运行方式|每个独立的进程有一个程序运行的入口、顺序执行序列和程序的出口|

### Spring Boot起步依赖

* Point

    starter配置,约定大于配置

* 标准回答
    
    Spring Boot 将日常企业应用研发中的各种场景都抽取出来,做成一个个的 starter（启动器）,starter 中整合了该场景下各种可能用到的依赖,用户只需要在 Maven 中引入 starter 依赖,SpringBoot 就能自动扫描到要加载的信息并启动相应的默认配置。starter 提供了大量的自动配置,让用户摆脱了处理各种依赖和配置的困扰。所有这些 starter 都遵循着约定成俗的默认配置,并允许用户调整这些配置,即遵循“约定大于配置”的原则。 那么我们看构建的项目的pom.xml文件中的starter配置。 <dependency> <groupid>org.springframework.boot</groupid> <artifactid>spring-boot-starter-web</artifactid> </dependency> 以 spring-boot-starter-web 为例,它能够为提供 Web 开发场景所需要的几乎所有依赖,因此在使用 Spring Boot 开发 Web 项目时,只需要引入该 Starter 即可,而不需要额外导入 Web 服务器和其他的 Web 依赖。 加分回答 有时在引入starter时,我们并不需要指明版本（version）,这是因为starter版本信息是由 spring-boot-starter-parent（版本仲裁中心） 统一控制的。

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

### T

* Point

* 标准回答

