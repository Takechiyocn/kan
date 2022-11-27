package generic;

/**
 * @description: 泛型可看作普通类的工厂
 * Java中类型变量：
 *   E：表示集合的元素类型
 *   K，V：表示表的关键字与值的类型
 *   T/U/S：表示任意类型
 *
 *   E - Element (used extensively by the Java Collections Framework)
 *   K - Key
 *   V - Value
 *   N - Number
 *   T - Type
 *   S,U,V etc. - 2nd, 3rd, 4th types
 * 泛型特点：
 *   1.虚拟机中没有泛型，只有普通的类和方法，即原始类型
 *   2.所有的类型参数都用它们的限定类型替换
 *   3.桥方法被合成来保持多态
 *   4.为保持类型安全性，必要时插入强制类型转换
 * 泛型用处：
 *   主要目标是允许泛型代码和遗留代码之间能够互操作
 * 约束与局限性：{@link generic.GenericTypeConstraint}
 * 通配符限定：{@link generic.wildcard.WildcardSubType}
 *           {@link generic.wildcard.WildcardSupperType}
 *           {@link generic.wildcard.WildcardNoType}
 *           {@link generic.wildcard.WildcardTypeCapture}
 *
 * @author: Kan
 * @date: 2021/3/10 0:24
 */
public class GenericTypeCommon<T> {
    // 泛型类：GenericTypeCommon<T>
    // 泛型类的类型变量
    private T first;
    private T second;

    public GenericTypeCommon() {
        first = null;
        second = null;
    }

    public GenericTypeCommon(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }

    /**
     * GenericTypeCommon<T>的equals(T)方法在类型擦除后和Object的equals(Object)方法发生冲突（因为没有重写）
     * 重写时，equals方法签名的参数类型应该与被重写方法(此处Object的equals)的类型(Object类型)一致
     * 以下为Object equals 方法原型
     *   public boolean equals(Object obj) {
     *       return (this == obj);
     *   }
     */
//    @Override
//    public boolean equals(T value) {
//        return first.equals(value) && second.equals(value);
//    }
    public boolean equals2(T value) {
        return first.equals(value) && second.equals(value);
    }

    /**
     * extends表示T应该是绑定类型Comparable的子类型
     * T和绑定类型可以是接口，也可以是类(即该接口/类必须实现了Comparable接口的类)
     *   -> 加入通配符的超类型限定后：该接口/类或其 **超类** 必须实现了Comparable接口的类
     *      （此处不用implements）
     * T：类型变量，通配符
     * T可有多个限定/绑定
     *   -> T extends Comparable & Serializable
     *   -> 上记限定可以有多个接口，但类限定只能有一个。并且类限定必须作为限定列表中的第一个
     *   -> 为提高效率，应该将标记接口(没有方法的接口，如Serializable)放在边界列表的末尾
     *
     * @param a     泛型数组
     * @param <T>   类型参数
     * @return      泛型类对象
     */
    public static <T extends Comparable> GenericTypeCommon<T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
        for (T s : a) {
            if (min.compareTo(s) > 0) {
                min = s;
            }
            if (max.compareTo(s) < 0) {
                max = s;
            }
        }
        return new GenericTypeCommon<>(min, max);
    }

    /**
     * 自定义泛型方法
     *   <T>整体：类型参数
     *   <T>中的T：类型变量，放在访问修饰符后，返回类型之前
     * 调用泛型方法时，方法名前的尖括号中放入具体类型(非原始类型)
     * 如：GenericTypeCommon.<String>getMiddle("john","abc");
     *    GenericTypeCommon.<Double>getMiddle(3.14,172,0);
     *
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    /**
     * 泛型类型变量与返回值类型不一致
     * J2SE1.5泛型机制约束：不能拿用标识符<T></>来代表的类型来创建这一类型（可变参数）的实例
     * J2SE1.8之前该函数会报generic array creation错误
     *
     * @param args
     * @param <T>
     */
    public static <T> void voidReturnType(T... args) {
        System.out.println("泛型类型变量与返回类型不一致，返回类型：void");
    }

    /**
     * 对类型变量T设置限定（bound）:原始类型绑定(extends Comparable)，有风险
     * T和绑定类型可以是接口，也可以是类(即该接口/类必须实现了Comparable接口的类)
     *  -> 加入通配符的超类型限定后：该接口/类或其 **超类** 必须实现了Comparable接口的类
     *
     *  public static <T extends Comparable> T min(T[] a) {}
     *   -> 只有实现了Comparable接口的类(如String，LocalDate(超类ChronoLocalDate实现)等)才能调用该方法
     *
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T smallest = a[0];
        for (T t : a) {
            if (smallest.compareTo(t) > 0) {
                smallest = t;
            }
        }

        return smallest;
    }

    /**
     * 对类型变量T设置限定（bound）:类型参数绑定(T extends Comparable<T>或T extends Comparable<? extends T>)，有风险
     * T和绑定类型可以是接口，也可以是类(即该接口/类必须实现了Comparable接口的类)
     *  -> 加入通配符的超类型限定后：该接口/类或其 **超类** 必须实现了Comparable接口的类
     *
     *  public static <T extends Comparable> T min(T[] a) {}
     *   -> 只有实现了Comparable接口的类(如String，LocalDate(超类ChronoLocalDate实现)等)才能调用该方法
     *
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T min2(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T smallest = a[0];
        for (T t : a) {
            if (smallest.compareTo(t) > 0) {
                smallest = t;
            }
        }

        return smallest;
    }
}
