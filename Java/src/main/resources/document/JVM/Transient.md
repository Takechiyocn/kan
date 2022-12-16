## transient和static

### transient

* transient(瞬态变量)修饰的成员变量，不能被序列化

* 瞬态变量生命周期只存在于调用者的内存中，不会在磁盘中持久化

* transient只能修饰变量，不能修饰类和方法

* 自定义类需要实现Serializable接口(不能是Externalizable接口)

  * Externalizable接口指定了强制序列化属性，故transient在该接口中无效(可被序列化)

* 局部序列化后，transient变量返回默认值，容易在程序中引发意想不到的结果(如等值判断或是数据库写入操作)，故不推荐使用

#### 使用场景

* 在序列化对象时，只需要将类中一部分序列化，而另一部分不序列化(如银行卡信息)

### static

* 静态变量优先于非静态变量加载到内存

    * 类装载的准备阶段：赋值0

    * 类装载的初始化阶段：类构造器<client>方法赋值put static

* 被static修饰的成员变量不能被序列化

