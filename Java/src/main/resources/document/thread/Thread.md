## 线程

### 多线程实现方式

* 继承Thread类，并重写run方法

* 实现Runnable接口，实现run方法

* 实现Callable接口，重写call方法，有返回值

* 通过线程池实现多线程ExecutorService(JUC中Executors工具类的顶级接口)

    
