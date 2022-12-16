## ThreadLocal

### 作用

ThreadLocal叫做线程变量，ThreadLocal中填充的数据只属于当前线程，变量的数据对别的线程而言是相对隔离的。
ThreadLocal为变量在每个线程中都创建了一个副本，每个线程都可以访问自己内部的副本变量

多线程环境下，可以防止自己的变量被其他线程篡改

### 使用场景

Spring实现事务隔离级别

1. 在进行对象跨层传递的时候，使用ThreadLocal可以避免多次传递，打破层次间的约束

2. 线程间数据隔离

3. 进行事务操作，用于存储线程事务信息

4. 数据库连接，Session会话管理

    ```java
    class ConnectionManager {
    private static Connection connect = null;
    //private static ThreadLocal<Connection> connect = new ThreadLocal<>();
    // 建立连接
    public static Connection openConnection() {
        if(connect == null){
            connect = DriverManager.getConnection();
        }
        return connect;
    }
    // 关闭连接
    public static void closeConnection() {
        if (connect != null)
            connect.close();
        }
    }
    ```

    * 问题1：如果客户频繁使用数据库，需要多次建立和关闭连接
    * 问题2：如果有上万个客户，服务器压力会很大
    * 解决：使用ThreadLocal在每个线程中创建一个副本，线程内部任何地方都可以使用

### 如何使用

