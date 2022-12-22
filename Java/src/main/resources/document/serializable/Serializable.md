## 序列化

    保存/持久化对象及其状态到磁盘/内存的过程
    远程方法调用RMI或网络中传输对象时，会用到对象序列化
    虚拟机是否允许序列化取决于类路径和功能代码是否一致，还取决于两个类的序列化ID是否一致
    即private static final long serialVersionUID

### Serializable序列化

* ObjectOutputStream

    序列化

* ObjectInputStream

    反序列化
  
### 自定义序列化

* writeObject

* readObject

### 优缺点

1. 性能极差

2. 序列化后体积不佳(包含对象的类信息)

    ```java
    class A {
    private String foo = "bar";
    }
    
    class B {
    private String foo = "bar";
    }
    ```
   
    * json化后，结果完全一致
    
    * 序列化后，结果不一致；反序列化时，A和B不相容

3. 只能用在Java上，无法跨语言

4. serializationID的存在造成向前兼容性不好，实践无法落地

### 替代

Java原生序列化已成为历史包袱，官方不建议使用，可用以下替代

1. json/yaml

2. protobuf

3. avro
