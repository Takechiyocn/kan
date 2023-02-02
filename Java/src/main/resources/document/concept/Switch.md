## Switch语句中数据类型

```java
switch(x) {
    default:
    System.out.println("Hello");
}
```

java只支持int类型的switch语句

Java为例，switch支持10种类型

* 基本类型：byte、Char、short、int

    自动向上转换为int

* 包装类：Byte、Character、Short、Integer

    自动拆箱转为基本类型

* String

    switch实际比较的是String.hashcode值，该值为int类型

* enum

    switch实际比较的是enum的ordinal值(表示枚举的顺序)，该值为int类型
