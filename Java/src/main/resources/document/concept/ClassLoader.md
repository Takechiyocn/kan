## 类加载顺序

程序初始化时，父类和子类代码执行顺序：

1. 静态变量、代码块

    1. 父类的静态变量->静态代码块(同一个类的静态代码块只被加载一次)

        ```java
        // 静态变量
        public static ParentStaticObject p = new ParentStatic(); 
        // 静态代码块
        static {
            System.out.println();
        }
        ```

    2. 子类的静态变量->静态代码块

        ```java
        // 静态变量
        public static SonStaticObject p = new ParentStatic(); 
        // 静态代码块
        static {
            System.out.println();
        }
        ```

2. 父类

    1. 父类的非静态变量、非静态代码块

        ```java
        {
            System.out.println();
        }
        ```

    2. 父类的构造函数

        ```java
        public HelloParent {
        }
        ```

3. 子类

    1. 子类的非静态变量、非静态代码块

        ```java
        {
            System.out.println();
        }
        ```

    2. 子类的构造函数

        ```java
        public HelloSon {
        }
        ```
       
### 代码解析

```java
public class B
{
    // 2. 加载主类静态变量(此处显示初始化)
    //   2.1 因为类B已经被主函数加载过一次，JVM认为此处的t1=new B()是第二次加载类，
    //       类B中的静态变量/代码块不会被再次初始化：static属于类级别只被加载一次
    //   2.2 加载非静态代码块：两次输出"构造块"
    //   2.3 加载构造函数，此处调用默认无参构造器，没有输出
    //      * 因为t1、t2属于类成员，本应初始化默认值为null
    // 3. 加载静态代码块：输出"静态块"
    // 4. 加载非静态代码块：输出"构造块"
    public static B t1 = new B();
    public static B t2 = new B();
    {
        System.out.println("构造块");
    }
    static
    {
        System.out.println("静态块");
    }
    // 输出：构造块 构造块 静态块 构造块
    public static void main(String[] args)
    {
        // 1. JVM加载类B，按照上述初始化代码父子类执行顺序规则
        //    1.1 加载父类静态变量->静态代码块
        //    1.2 加载父类非静态变量，非静态代码块
        //    1.3 加载父类构造函数
        B t = new B();
    }
}
```
