## HashMap扩容原理

### HashMap数据结构

JDK1.7：数组+链表
JDK1.8：红黑树

链表：节点存储一个Entry对象

Entry对象：存储四个属性(hash、key、value、next)

![HashMapDataStructure.png](images/HashMapDataStructure.png)

### HashMap扩容为什么总是2的次幂

HashMap扩容公式：initialCapacity * loadFactor = HashMap

**默认当16\*0.75=12时，HashMap扩容；初始容量和负载因子可自己设定**

初始容量(initialCapacity)：默认16(懒加载机制，第一次put时创建)
```java
// The default initial capacity - MUST be a power of two.
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
```

负载因子loadFactor：默认0.75
```java
// The load factor used when none specified in constructor.
static final float DEFAULT_LOAD_FACTOR = 0.75f;
```

使用位运算扩容原因：

* 使添加元素能充分散列(均匀分布在HashMap每个位置)，减少hash碰撞(导致某一链表特别长，影响查询效率)
* 位运算高效(取模运算速度较低故不使用)
```java
// 添加元素时计算该元素在集合中位置
// n：HashMap数组长度
(first = tab[(n - 1) & (hash = hash(key))]
```

HashMap容量是2次幂时，hash计算结果：无hash碰撞

![HashMapResizeSample.png](images/HashMapResizeSample.png)

HashMap容量不是2次幂时，hash计算结果：多次hash碰撞

![HashMapResizeSample2](images/HashMapResizeSample2.png)

### JDK1.8新结构：红黑树
