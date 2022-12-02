# JUC

![JUCSummary.png](images/JUCSummary.png)

## JUC概述

### 相关概念

* 线程
  
    操作系统能够进行运算调度的最小单位

* 进程
  
    一个运行中的程序的集合，一个进程至少包含一个线程

* Java默认2个线程：main线程和gc线程

* 并发

    多线程操作同一个资源，交替执行
  
* 并行

    多个操作同时进行

* wait/sleep区别

    区别|wait|sleep
    ---|---|---
    来源|Object类|线程类
    锁的释放|释放锁|不释放锁
    使用范围|同步代码块中|任何地方

### JUC结构

![JUCInfrastructure.png](JUCInfrastructure.png)

#### tools(工具类)

信号量三组工具类

#### executor(执行者)

Java线程池的顶级接口，此处只是一个执行线程的工具。真正的线程池接口是ExecutorService

#### atomic(原子性包)

JDK提供的一组原子操作类

#### locks(锁包)

JDK提供的锁机制

#### collections类

主要提供线程安全的集合
