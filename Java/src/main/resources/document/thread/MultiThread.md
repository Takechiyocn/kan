## 说说多线程

### 特点

1. 线程是操作系统调度的最小单元，一个进程可以拥有多个线程，使用多线程可以并发地处理多个任务

    1. 进程：一个运行中的程序的集合，一个进程至少包含一个线程

    2. 并发：同一时刻，多个线程交替执行(一个CPU交替执行线程)

    3. 并行：同一时刻，多个线程同时执行(多个CPU同时执行多个线程)
    
2. 各个线程之间共享程序的内存空间(代码段、数据段和堆空间)和系统分配的资源(CPU/IO/打开的文件)

3. 各个线程拥有自己的程序计数器、栈空间

### 多线程优点

1. 减少程序响应时间

2. 提高CPU利用率

3. 相对进程而言，创建和切换开销小

4. 共享数据效率高

5. 简化程序结构

### 如何保证线程安全/线程同步方式(主要回答3.锁)

线程安全问题指的是多线程背景下，线程没有按照我们的预期执行，导致操作共享变量出现异常

Java提供许多同步方案供我们使用，从轻到重同有三种方式

1. 原子类：保证单个共享变量的线程安全

   1. 原子类是juc atomic包下的一系列类，通过CAS比较与交换的机制(通过预期值与内存值的比较来判断是否修改)实现线程安全的更新共享变量
   
   2. 实现原子更新的原理：
   
      1. for死循环获取原子类存储值(AtomicInteger)
      2. 对该值+1
      3. 调用compareAndSet进行原子更新
         1. 检查当前数值是否等于expect
         2. 等于，则未被其他线程修改，当前值更新为expect
         3. 不等于，则被其他线程修改，进入下一轮for循环(自旋)
   
2. volatile关键字：保证单个共享变量的线程安全

   1. Java提供的一种免锁的同步访问机制，volatile变量直接从主内存读写最新值
   
      1. 变量可见性：保证变量对所有线程可见(线程修改后新值对其他线程可见)
   
         每次从主内存读取最新值
   
      2. 禁止指令重排：内存屏障指令禁止重排序
   
         程序不是按照编写顺序执行，指令重排时会考虑数据之间的依赖性
   
         1. 编译器优化重排
   
         2. 指令并行重排
   
         3. 内存系统重排
   
      3. 不保证原子性：线程不安全
   
         如域翻转done = !done
   
      4. 不会造成阻塞，不可用于多线程下的计数器
   
3. 锁：保证临界区内多个共享变量的安全

   1. 常用锁
   
      1. synchronized关键字
   
         1. 互斥的可重入锁
   
         2. 可作用于实例方法、静态方法、代码块
   
            1. 实例方法：锁住当前实例(this)对象
               
            2. 静态方法：锁住当前类对象
               
            3. 代码块：需要在synchronized后小括号里显示指定锁对象

         3. 并发环境中synchronized会随着线程竞争的加剧升级
            
            1. 无锁->偏向锁->轻量级锁->重量级锁
            
         4. 适用于少量代码的同步
   
         5. 原理
   
            1. 底层采用Java对象头来存储锁信息，对象头：
   
               1. Mark Word：存储对象的hashCode和锁信息(锁标志和锁状态)
   
               2. Class Metadata Address：存储对象类型的指针
   
               3. Array length：存储数组对象的长度，非数组对象没有该信息
   
            2. 随着线程竞争的升级，Java6锁状态会从无锁->偏向锁->轻量级锁->重量级锁升级，无法降级。锁升级过程：
               
               1. 开始没有任何线程访问同步块，此时同步块处于无锁状态
   
               2. 线程1访问，以CAS方式修改Mark Word，尝试加偏向锁；此时无竞争，偏向锁加锁成功
                  
               3. 线程2访问，以CAS方式修改Mark Word，尝试加偏向锁，此时存在竞争，偏向锁加锁失败；线程2撤销偏向锁；线程1、2恢复成可以竞争的状态
                  
               4. 线程1、2竞争，同时以CAS方式修改Mark Word，尝试加轻量级锁；假如线程1成功获取锁，线程2不放弃进行自旋加锁
   
               5. 线程1很快执行完毕，线程2加轻量级锁；线程1执行时间长，线程2自旋一定次数后放弃自旋，发起锁膨胀流程，并升级成重量级锁，线程2进入阻塞状态；线程1重复加锁或解锁时，CAS操作失败，线程1释放并唤醒等待线程，线程2获取锁

      2. juc包下的lock锁
   
         1. 通过lock、unlock锁住代码实现同步，基于AQS实现
   
            1. ReentrantLock：通常和Condition配合使用，精准的通知和唤醒线程，依赖于Lock接口的接口，基本方法await()和signal()
   
            2. ReentrantReadWriteLock
            
         2. 将阻塞队列存储在AQS的双向队列中
   
         3. 适合锁大量的同步代码(只有代码块锁)，性能高
   
         4. 根据锁的使用场景，派生出公平锁、非公平锁、读锁、写锁等

4. 其他

   1. juc包提供的线程同步工具类
   
      1. CountDownLatch
   
         允许一个或多个线程等待其他线程完成操作
   
      2. Semaphore
   
         信号量，可以控制同时访问特定资源的线程数量
   
      3. CyclicBarrier
   
         让一组线程到达一个屏障时被阻塞，直到最后一个线程到达屏障后，屏障才会打开，所有阻塞线程才会继续运行
      
   2. ThreadLocal
   
      1. 定义线程局部变量，为每一个线程单独保存一个副本，隔离了多个线程之间的数据共享

### 线程安全的集合

* java.util包下集合类：性能差

   * Vector
   
   * Hashtable
   
   * 其他：线程不安全
   
      * 可使用Collections工具类提供的synchronizedXxx()方法将集合类包装成线程安全的集合类
      
         * Collections.synchronizedSet(new HashSet());
           
         * Collections.synchronizedList(new ArrayList());
           
         * Collections.synchronizedMap(new HashMap());
   
*  juc：java.util并发包下的容器

   * Concurrent开头的容器：降低锁粒度来提高并发性能
   
      * ConcurrentHashMap
   
   * CopyOnWrite开头的容器：写时复制技术(复制到新容器，引用指向新容器)
   
      * CopyOnWriteArrayList：适用于读多写少
   
   * 采用Lock锁实现的阻塞队列
   
      * 内部采用两个Condition分别用于生产者和消费者的等待，这些类都实现了BlockingQueue
   
      * ArrayBlockingQueue：有界队列，底层数组实现
   
      * LinkedBlockingQueue：无界队列(也可当做有界队列)，底层单向链表实现
        
      * PriorityBlockingQueue：支持优先级的无界队列，PriorityQueue的线程安全版本
      
* Collections的如下方法：返回不可变的集合

   * EmptyXxx：返回空的不可变的集合对象

      * EmptyList

      * EmptySet

      * EmptyMap
      
   * SingletonXxx：返回一个包含特定对象的不可变的集合对象
   
      * SingletonList
        
      * SingletonSet
        
      * SingletonMap
   
   * UnmodifiableXxx：返回指定结合对象的不可变视图

      * UnmodifiableList

      * UnmodifiableSet

      * UnmodifiableMap
   