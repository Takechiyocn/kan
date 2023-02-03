## 类成员变量和成员方法

* 成员变量
  
    * 类变量:静态成员变量
  
    * 实例变量:对象成员变量

* 成员方法

    * 类方法:静态方法

    * 实例方法:非静态方法
  
### Java访问变量

采用就近原则

* 局部变量与成员变量重名时，局部变量较近，就是用局部变量

  局部变量未初始化使用时编译出错

* 如果使用this，则使用成员变量

```java
public class Demo {
    private String s = "成员变量";
    public void useDemo() {
        String s = "局部变量";
        System.out.println(this.s);
        System.out.println(s);
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        // 输出：
        //    成员变量
        //    局部变量
        demo.useDemo();
  }
}
```