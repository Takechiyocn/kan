## 线程

### 关键字

volatile

* 概述

    一种免锁同步访问机制，volatile变量直接从主存读写最新值

* 作用

    * 变量可见性：保证变量对所有线程可见，即线程修改后新值对其他线程可见
  
    * 禁止指令重排
  
* volatile变量传递性

  如果A happens-before B, B happens-before C，那 A happens-before C

### 