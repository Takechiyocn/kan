package jdk8feature.stream;

import bean.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        list.stream()
                .filter(user -> {return user.getId()%2 ==0;})
                .filter(user -> {return user.getAge() > 23;})
                .map(user -> {return user.getName().toUpperCase();})
                .sorted((uu1, uu2) -> {return uu2.compareTo(uu1);})
                .limit(1)
                .forEach(System.out::println);
    }

}
