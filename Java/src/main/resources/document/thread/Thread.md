## 线程

### 多线程实现方式

* 继承Thread类，并重写run方法

    Thread默认继承Runnable接口

    ```java
    class ThreadExtends extends Thread {
        // 重写Thread接口内run方法
        // Thread接口内run方法默认重写Runnable接口内run方法
    }
    // 执行线程
    new ThreadExtends().start();
    ```

* 实现Runnable接口，实现run方法

    * 传统实现Runnable接口

      ```java
      class ThreadImplements implements Runnable {
          // 重写Runnable接口内run方法
      }
      // 执行线程
      new Thread(new ThreadImplements()).start();
      ```

    * Lambda间接实现接口
      
      ```java
      // 方式1
      new Thread(() -> {
          // 以下为Runnable接口内run()方法的实现
              }).start();
      // 方式2
      Runnable r = () -> {
          // 以下为Runnable接口内run()方法的实现
              };
      new Thread(r).start();
      ```
* 实现Callable接口，重写call方法，有返回值

* 通过线程池实现多线程ExecutorService(JUC中Executors工具类的顶级接口)

    
