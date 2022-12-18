package datatype;

/**
 * 值类型(基本类型)：
 *      整形
 *      字符类型
 *      浮点型
 *      布尔型
 * 引用类型(复合类型)：
 *      类类型
 *          Object类：所有类的父类
 *          String类：String类代表字符串
 *                   在一定的场合表现出一定的值类型特点
 *      数组
 *      接口类型
 * 区别：基本数据类型分配在栈上，引用数据类型分配在堆上
 *      基本数据类型和引用数据类型均会在栈上分配内存，该内存值为：
 *        1.基本数据类型：基本类型的内容
 *          (如int a = 3; 在栈中创建变量a的引用，并指向栈中字面值为3的地址，如没有则开辟栈空间存放3)
 *        2.引用数据类型：指向真正内容的指针，该指针指向存放真正内容的堆
 * @author moku
 */
public class DataTypeInJava {

    public static void main(String[] args) {

        // 栈区创建str引用，指向存放在常量池中的值("abcd")
        String str = "abcd";
        // str2和str均指向同一引用地址，即str == str2 为true
        String str2 = "abcd";
        System.out.println("常量池引用：" + (str == str2));

        // str重新赋值(指向不同引用)，指向存放在常量池中的值("abc")
        str = "abc";
        // str和str3均指向同一引用地址，即str == str3 为true
        String str3 = "abc";
        System.out.println("常量池引用2：" + (str == str3));

        // str重新赋值(指向不同引用)
        // "abc" + "d"为编译时确定，指向常量池中既有的"abcd"，即str == str2 为true
        str = "abc" + "d";
        System.out.println("拼接字符串(编译时确定，存放于常量池)：" + (str == str2));

        // str3 + "d"为运行时创建，运行时在堆上创建"abcd"对象，即str == str3 为false
        str3 = str3 + "d";
        // false
        System.out.println("拼接字符串(运行时确定，存放于堆变量)：" + (str == str3));

        // 直接在堆上创建对象
        String str4 = new String("abcd");
        // false
        System.out.println("堆上创建对象：" + (str == str4));

        // 在堆上重新创建对象
        String str5 = new String("abcd");
        System.out.println("堆上创建对象2：" + (str4 == str5));

        // 值类型特点：按值传递
        String str6 = "ab";
        stringConcat(str6);
        System.out.println("常量池：" + ("ab" == str6));
        System.out.println("str6：" + str6);
    }

    // 因为String为不可变对象，所以字符串连接会产生新的对象，并不更改原始对象的指向
    public static void stringConcat(String str) {
        // 执行前：str和调用处的str6均指向常量池中的"ab"
        // 执行后：str指向堆中新地址"ab123"，调用处的str6指向不变
        str = str + "123";
    }
}
