## transient和static

## transient

* 被transient(瞬态变量)修饰的成员变量，不能被序列化

### static

* 静态变量优先于非静态变量加载到内存

    * 类装载的准备阶段：赋值0

    * 类装载的初始化阶段：类构造器<client>方法赋值put static

* 被static修饰的成员变量不能被序列化

