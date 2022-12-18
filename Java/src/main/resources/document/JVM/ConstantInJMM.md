## 运行时常量池

### 直接量

以String s = "abc";形式的赋值在java中叫直接量，存放在常量池中，而非new一样保存在堆中

### 符串拘留池(string interning pool)

公共语言运行库会自动维护一个名为“拘留池”(intern pool) 的表，
它包含程序中以编程方式声明或创建的每个唯一的字符串的一个引用。因此，具有特定值的字符串的实例在系统中只有一个。

### 字符串拘留

直接量形式的字符串在JVM内部发生字符串拘留(String intern)，
即声明直接量字符串后，JVM先在常量池中寻找值相等的对象，如有，则将其赋予当前引用；
如没有，则新建值。这种现象叫字符串拘留

简而言之，编译阶段(含)确定的字符串直接量会发生字符串拘留

### 字符串

* 直接量

    ```java
    String a = "hello"; // 语句1
    String b = "hello"; // 语句2
    System.out.println(a==b); // true：指向相同引用
    ```

    * 常量池中创建值为"hello"的String对象(string table)
  
    * 语句1执行，"hello"的引用赋给a
      
    * 语句2执行，"hello"的引用赋给b
    
    * 引用对象a、b存放在虚拟机栈里,指向相同引用
      
    * ==操作比较引用所指向的内存地址是否相同(指针操作&a、&b)

* 对象内字面量

  ```java
  String a = new String("hello"); // 语句1
  String b = new String("hello"); // 语句2
  System.out.println(a==b); // false：指向不同引用
  ```
  * 语句1执行，在堆中创建字符串对象，将引用赋给a
    
  * 语句2执行，在堆中创建字符串对象，将引用赋给b

  * 引用对象a、b存放在虚拟机栈里，指向不同引用

### 字符串长度

* 直接量
  
  String a = "xxx":小于65535

* 创建对象
  
  String a = new String("xxx"):小于int最大值

  