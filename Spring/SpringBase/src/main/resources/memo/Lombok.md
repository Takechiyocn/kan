## Lombok注解

主街名称|功能
---|---
@Setter|自动添加类中所有属性相关的set方法
@Getter|自动添加类中所有属性相关的get方法
@Builder|使得该类可以通过builder(建造者模式)构建对象
@RequiredArgsConstructor|生成一个该类的构造方法，禁止无参构造
@NoArgsConstructor|生成一个该类的无参构造方法
@AllArgsConstructor|生成一个该类的包含所有参数的构造方法
@ToString|重写该类的toString()方法
@EqualsAndHashCode|重写该类的equals()和hashCode()方法
@Data|等价于@Setter、@Getter、@RequiredArgsConstructor、@ToString、@EqualsAndHashCode

### @RequiredArgsConstructor

@RequiredArgsConstructor注解则会将类中所有带有@NonNull注解 / org.jetbrains.annotations.NotNull注解的或者带有final修饰的成员变量生成对应的构造方法
```java
@RequiredArgsConstructor
public class Demo {

    @NonNull
    private final int finalVal;
    @NonNull
    private String name;
    @NonNull
    private int age;
}

// 编译后
import lombok.NonNull;

public class Demo {
    @NonNull
    private final int finalVal;
    @NonNull
    private String name;
    @NonNull
    private int age;

    public Demo(@NonNull int finalVal, @NonNull String name, @NonNull int age) {
        if (name == null) {
            throw new NullPointerException("name is marked non-null but is null");
        } else {
            this.finalVal = finalVal;
            this.name = name;
            this.age = age;
        }
    }
}
```

### @Data

@Data注解包含以下注解：

* @Setter

* @Getter

* @RequiredArgsConstructor

* @ToString

* @EqualsAndHashCode(callSuper = false)

    * 含义：在重写hashCode和equals时只重写当前类的数据，不重写父类的数据

    * 问题：一个类添加@Data注解并继承了一个类，基于子类创建的两个对象equal时，可能导致预想外结果
    
    * 解决：
    
        * 用了@Data注解就不要有继承关系
    
        * 自己重写equals方法(Lombok不对显示重写的方法进行生成)
    
        * 显示使用@EqualsAndHashCode(callSuper = true)

### 