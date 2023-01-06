## JDK8新特性

### Lambda表达式

### 方法引用

### 函数式接口

函数式接口(Functional Interface)是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口

函数式接口可以对现有的函数有好地支持lambda

1. JDK1.8以前函数式接口

   java.lang.Runnable
   java.util.concurrent.Callable
   java.security.PrivilegedAction
   java.util.Comparator
   java.io.FileFilter
   java.nio.file.PathMatcher
   java.lang.reflect.InvocationHandler
   java.beans.PropertyChangeListener
   java.awt.event.ActionListener
   javax.swing.event.ChangeListener

1. JDK1.8新增函数式接口

    java.util.function

    1. BiConsumer<T,U>
    
        代表了一个接受两个输入参数的操作，并且不返回任何结果
       
    2. BiConsumer<T,U,R>

       代表了一个接受两个输入参数的方法，并且返回一个结果

    3. BinaryOperator<T>

       代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果

    4. BiPredicate<T,U>
       
       代表了一个两个参数的boolean值方法

    5. Supplier：供给型函数式接口

       无参数，返回一个结果

    6. Consumer<T>：消费型函数式接口

        代表了接受一个输入参数并且无返回的操作

    7. Function<T,R>

        接受一个输入参数，返回一个结果。

    8. Predicate<T>

       接受一个输入参数，返回一个布尔值结果。

### 接口默认方法

接口可以有实现方法，但需用default标注为默认方法

### Stream

### Optional类

Optional类是一个可以为null的容器对象，可不用显示进行空值检测。

* isPresent：值存在，返回true

* get()：返回该对象

### Nashorn, JavaScript 引擎

Java嵌入式JavaScript引擎，可在Java中执行JavaScript代码

* JDK1.8前：Rhino

* JDK1.8后：Nashorn

* JDK11后：Nashorn被标注为不可用deprecated

### 新的日期事件API



