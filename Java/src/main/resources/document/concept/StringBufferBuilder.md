## 不可变字符串

不能直接修改字符串的值，只能通过改变变量指向的引用达到值更改的效果

不可变字符串：String

可变字符串：StringBuilder、StringBuffer(因为实现了Appendable接口)

## 区别

区别|String|StringBuffer|StringBuilder
---|---|---|---
可变|不可变|可变|可变
实现|字符数组(CharSequence)|字符数组(CharSequence)|-
线程安全|不安全|安全|不安全
访问修饰符final修饰|有|有|无
字符数组(为引用类型)|final修饰有|final修饰无|-
equals/hashCode重写|重写|未重写|未重写
使用场景|少量数据且不可变|多线程下大量数据|单线程下大量数据

访问修饰符final类：类无法被继承

字符数组final有无：值无法改变

## String

* String类被final修饰，不能被继承

* 创建字符串的两种方式

    * 字符串直接量：编译时确定的字符串(会发生字符串拘留)
      
        * 创建方式
          
            ```java
            // 直接定义直接量
            String str = "abcd";
            // 拼接字符串也属于编译时确定
            str = "abc" + "d";
            ```
    
        * 存放位置：常量池
    
        * JVM运行方式：
          
            * JVM先在常量池内寻找是否有该字符串
    
            * 有：则使用该字符串，两个字符串地址相等即==为true
    
            * 没有：常量池新建一个
    
    * 对象内字面量(new)：运行时确定的字符串
    
        * 创建方式
              
            * 通过new创建
        
                ```java
                String str4 = new String("abcd");
                ```
              
            * 字符串拼接
    
                ```java
                String str3 = "abc";
                str3 = str3 + "d";
                ```
              
        * 存放位置：对象存放在堆中，变量存放在栈中

        * JVM运行方式：

            1. JVM先在常量池内寻找是否有该字符串
    
                * 有：则使用该字符串
                
                * 没有：常量池新建一个

            2. 在堆内存创建一个新的对象
    
                * 因为是不同对象，所以地址不相等即==为false
    
            3. 栈内存放的变量指向堆内对象，堆里的对象指向常量池字面量

               * 相比直接量多占用一个对象空间
    
* 重写了equals和hashCode方法

## StringBuffer和StringBuilder区别

### 一.字符修改上的区别

![StringBufferBuilderDifference.png](../method/images/StringBufferBuilderDifference.png)

1. 当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。
2. 和 String 类不同的是，StringBuffer 和 StringBuilder类的对象能够被多次的修改，并且不产生新的未使用对象。
3. StringBuilder和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
4. 由于 StringBuilder 相较于 StringBuffer 有速度优势，多数情况下建议使用 StringBuilder类。然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。

![StringBufferBuilderScene.png](../method/images/StringBufferBuilderScene.png)

### 二. 继承结构

![StringBufferBuilderInheritance.png](../method/images/StringBufferBuilderInheritance.png)

### 三.StringBuffer 和 StringBuilder区别详解

1. 线程安全

    * StringBuffer：线程安全
    * StringBuilder：线程不安全

    因为 StringBuffer 的所有公开方法都是 synchronized 修饰的，而 StringBuilder 并没有
    ```java
    @Override
    public synchronized StringBuffer append(String str) {
        toStringCache = null;
        super.append(str);
        return this;
    }
    ```
2. 缓冲区

* StringBuffer 代码片段：
    ```java
    private transient char[] toStringCache;
    
    @Override
    public synchronized String toString() {
        if (toStringCache == null) {
            toStringCache = Arrays.copyOfRange(value, 0, count);
        }
        return new String(toStringCache, true);
    }
    ```
* StringBuilder代码片段
    ```java
    @Override
    public String toString() {
        // Create a copy, don't share the array
        return new String(value, 0, count);
    }
    ```
* StringBuffer 每次获取 toString 都会直接使用缓存区的 toStringCache 值来构造一个字符串。
* 而 StringBuilder 则每次都需要复制一次字符数组，再构造一个字符串。
* 缓存冲这也是对 StringBuffer 的一个优化，不过 StringBuffer 的这个toString 方法仍然是同步的。

3. 性能

    StringBuffer是线程安全的，它的所有公开方法都是同步的，StringBuilder 是没有对方法加锁同步的，所以毫无疑问，StringBuilder的性能要远大于StringBuffer。

4. 是否实现了equals和hashCode方法

    * String:实现了equals()方法和hashCode()方法，new String("java").equals(new String("java"))的结果为true；
    * StringBuffer:未实现equals()方法和hashCode()方法，new StringBuffer("java").equals(new StringBuffer("java"))的结果为false
    * StringBuilder:未实现equals()方法和hashCode()方法，new StringBuilder("java").equals(new StringBuilder("java"))的结果为false
    
### 作用领域

![StringBufferBuilderScene2.png](../method/images/StringBufferBuilderScene2.png)


