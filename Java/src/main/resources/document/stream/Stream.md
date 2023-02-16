## Stream

Java8新特性：Stream流

>将集合或数组转换成一种流的元素序列

特点：

* 流不是集合中的元素，也不是一种数据结构，不负责数据存储

* 流不会改变源对象(源集合)

* 通常和函数式接口、lambda表达式、链式编程共同使用

### 链式编程TODO

### Collection接口stream()方法

Collection.stream()得到一个Stream流对象，通过该对象可以调用Stream接口相应的方法对集合进行过滤、排序、截断(丢弃/获取)等操作

### map()和peek()

1. map()：函数型接口参数，有返回值
```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
```

2. peek：消费型接口参数，无返回值
```java
Stream<T> peek(Consumer<? super T> action);
```