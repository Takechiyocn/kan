### JavaBean关于为什么要重写hashCode()方法和equals()方法及如何重写

    记得有一次去面试Java软件开发工程师,面试官问了我一个关于JavaBean为什么要重写hashCode()方法和equals方法,
    我记得当时我巴拉巴拉半天就是没有说到重点,现在想一想归根到底还是我对这两个的理解不深刻,
    现在我特定来总结下.hashCode方法用于散列集合的查找，equals方法用于判断两个对象是否相等。

#### 一、我们为什么需要重写hashCode()方法和equals()方法?（Why）`

    有时在我们的业务系统中判断对象时有时候需要的不是一种严格意义上的相等，而是一种业务上的对象相等。
    在这种情况下，原生的equals方法就不能满足我们的需求了.
    我们所知道的JavaBean的超类(父类)是Object类,JavaBean中的equals方法是继承自Object中的方法.
    Object类中定义的equals()方法是用来比较两个引用所指向的对象的内存地址是否一致.并不是比较两个
    对象的属性值是否一致,所以这时我们需要重写equals()方法.

*Object类中equals()方法的源码*

```java

    public boolean equals(Object obj){
        return(this==obj);
    }

    public class Demo {
        /*因为Student这个JavaBean没有重写关于属性值相等的equals()方法
        ,所以默认比较的是地址值,从而输出结果为false*/
        public static void main(String[] args) {
            Student stu1 = new Student("awu", 22);
            Student stu2 = new Student("awu", 22);
            System.out.println(stu1.equals(stu2));
        }
    }
```

**那么为什么在重写equals方法的时候需要重写hashCode方法呢？**
*主要是Object.hashCode的通用约定：*

1. 在java应用程序运行时，无论何时（对象的当前状态不变）多次调用同一个对象时的hashCode()方法， 这个对象的hashCode()方法的返回值必须是相同的一个int值.
2. 如果两个对象equals()返回值为true,则他们的hashCode()也必须返回相同的int值.
3. 如果两个对象equals()返回值为false,则他们的hashCode()返回值也必须不同.

*为什么要这样约定*

以HashSet来说明为什么要这么约定：HashSet存放元素时，根据元素的hashCode值快速找到要存储的位置。

1. 如果两个对象的hashCode()返回值相同（即这个位置有元素）

    a. 两个对象通过equals()比较，如果返回值为true,则不放入。
   
    b. 如果返回值为false,则这个时候会以链表的形式在同一个位置上存放两个元素，这会使得HashSet的性能降低，因为不能快速定位了。

2. 如果两个对象的hashCode()返回值不同（即这个位置没有元素）

    c. 两个对象通过equals()比较，如果返回值为true 这个时候HashSet会把这两个对象都存进去，这就和Set集合不重复的规则相悖了。

所以，我们重写了equals()方法时，要按照b,c规则重写hashCode()方法！
（**其实就是如果只重写了equals方法，两个对象equals返回了true，但是如果没有重写hashCode方法，集合还是会插入元素。这样集合中就出现了重复元素了。**）

#### 二、在什么情况下需要重写hashCode()方法和equals()方法? (When)

当我们自定义的一个类，想要把它的实例保存在以Hash散列查找的集合中时,我们就需要重写这两个方法。

```java
public class Student {
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + name.hashCode();
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Student other = (Student) obj;
        if (!name.equals(other.name)) {
            return false;
        }
        if (!age.equals(other.age)) {
            return false;
        }
        return true;
    }
}

public class Demo {
    public static void main(String[] args) {
        Student stu1 = new Student("awu", 22);
        Student stu3 = new Student("awu", 33);
        Student stu2 = new Student("awu", 22);

        Set set = new HashSet();
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);

        System.out.println(set.size());
        /*输出结果为2*/
    }
} 
```

如果不是以Hash散列查找(散列表)的集合,即使重写HashCode也没多大实际用处.比如如下栗子:

```java
public class Demo {
    public static void main(String[] args) {
        Student stu1 = new Student("awu", 22);
        Student stu3 = new Student("awu", 33);
        Student stu2 = new Student("awu", 22);

        ArrayList list = new ArrayList();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        System.out.println(list.size());
        /*输出结果为3*/
    }
}
```

#### 三、如何重写这两个方法？(How)

```java
public class Student {
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + name.hashCode();
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Student other = (Student) obj;
        if (!name.equals(other.name)) {
            return false;
        }
        if (!age.equals(other.age)) {
            return false;
        }
        return true;
    }
}
```
