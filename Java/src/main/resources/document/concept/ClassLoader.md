## 类加载顺序

程序初始化时，父类和子类代码执行顺序：

1. 静态变量、代码块

    1. 父类的静态变量、静态代码块

        ```java
        static {
            System.out.println();
        }
        ```

    2. 子类的静态变量、静态代码块

        ```java
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
