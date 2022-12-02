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

## JUC结构

![JUCInfrastructure.png](JUCInfrastructure.png)

### tools(工具类)

信号量三组工具类

### executor(执行者)

Java线程池的顶级接口，此处只是一个执行线程的工具。真正的线程池接口是ExecutorService

### atomic(原子性包)

JDK提供的一组原子操作类

### locks(锁包)

JDK提供的锁机制

### collections类

主要提供线程安全的集合

## Lock锁

### 传统synchronized

Java中的关键字，是一种同步锁。修饰对象：

1. 代码块

    被修饰的代码块称为同步语句块

    作用范围：大括号{}括起来的代码，作用对象是调用这个代码块的对象

    范例：synchronized (obj) {// 作用范围}
   
2. 方法

    被修饰的方法称为同步方法

    作用范围：整个方法，作用对象是调用这个方法的对象

    范例：public synchronized void transfer() {// 作用范围}
   
3. 静态方法

    作用范围：整个静态方法，作用对象是这个类的所有对象
   
4. 类

    作用范围：synchronized后面括号括起来的部分(内部方法看如何定义而定)，作用对象是这个累的所有对象