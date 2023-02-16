package jdk8feature.stream;

import bean.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamBase
 * @Description
 * @Author moku
 * @Date 2022/12/14 22:44
 * @Version 1.0
 */
public class StreamBase {
    // 筛选用户，5个条件：
    //  1. ID是偶数
    //  2. 年龄大于23
    //  3. 用户名转化为大写
    //  4. 用户名字母倒着排序
    //  5. 只输出一个用户
    public static void main(String[] args) {
        User u1 = new User(1, "A", 23);
        User u2 = new User(2,"B",21);
        User u3 = new User(3,"C",25);
        User u4 = new User(4,"D",30);
        User u5 = new User(5,"E",28);

        // 集合负责存储
        List<User> list = new ArrayList<>(Arrays.asList(u1, u2, u3, u4, u5));
        // 流负责计算
        list = list.stream()
                // 过滤
//                .filter(user -> {return user.getId()%2 ==0;})
//                .filter(user -> {return user.getAge() > 23;})
                // map:支持函数式接口(Function:函数型接口)
                // 返回给定函数应用于此流的结果组成的流，此处返回String字符串user.getName().toUpperCase()
//                .map(user -> {return user.getName().toUpperCase();})
                // 针对String类型字符串，非对象
//                .map(String::toUpperCase)
                .peek(user -> user.setAge(user.getAge()+1))
//                .sorted((uu1, uu2) -> {return uu2.compareTo(uu1);})
//                .limit(3)
                .collect(Collectors.toList());
//                .forEach(System.out::println);
        System.out.println(list);
    }
}
