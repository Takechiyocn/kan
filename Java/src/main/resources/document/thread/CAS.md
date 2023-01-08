## CAS

### 定义

Compare And Swap，比较并交换

* CAS(Compare And Swap)操作数:

    * V：需要读写的内存内置V
      
    * A：进行比较的预期值A
      
    * B：拟写入的新值B
    
* 操作逻辑：
  
    ```java
    // compare
    if (V == A) {
        // swap
        V == B;
    } else {
        do nothing;
    }
    // 不管更新与否都返回V的旧值
    return V;
    ```

* 许多CAS操作都是自旋的，即操作不成功则一直重试直到成功为止

* CAS原子性：
  
    * Compare和Swap两个操作是CPU支持的原子性操作，即硬件层面支持
    
### CAS问题

1. 出现ABA问题(多线程下只关心起始值和最终值，不关心中间过程)
  
  * 线程1读取共享内存的值A，线程1时间片用完，切换到线程B
  
  * 线程2修改该值为B，随后又修改成A
    
  * 切换到线程1，判断A值是预期值，对共享变量进行更新
    
  * 样例：会员充值系统(小于20免费充20)
  
      * 对某一会员卡系统，线程1充了20
  
      * 会员消费20
  
      * 线程2发现余额小于20，又充20，循环
  
2. 解决方式

  * 带版本号的juc包下的AtomicStampedReference类

  * 传统的互斥同步，如synchronized锁

3. ABA问题大部分情况下不会影响程序并发的正确性

### 原子类

1. 原子更新基本类型

  * AtomicInteger

  * AtomicLong

  * AtomicBoolean

2. 原子更新数组类型

  * AtomicIntegerArray
  
  * AtomicLongArray
  
  * AtomicReferenceArray

3. 原子更新引用类型

  * AtomicReference

  * AtomicStampedReference：带有版本号的引用类型

4. 原子更新字段类型

  * AtomicIntegerFieldUpdater

  * AtomicLongFieldUpdater

  * AtomicReferenceFieldUpdater

### AtomicInteger实现原子更新原理

如getAndIncrement以原子方式将当前的值加1，步骤：

1. 在for死循环中获取AtomicInteger存储的数值

2. 对AtomicInteger当前的值加1

3. 调用compareAndSet方法进行原子更新

  1. 检查当前数值是否等于except

  2. 等于则说明当前值未被其他线程修改，则将当前值更新为next

  3. 否则更新失败返回false，程序进入for循环重新进行compareAndSet操作

