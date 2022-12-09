package com.kan.annonation.lombok.data.test;

import com.kan.annonation.lombok.data.entity.User1;
import com.kan.annonation.lombok.data.entity.User2;

/**
 * @ClassName DataTest
 * @Description
 * @Author moku
 * @Date 2022/12/10 1:01
 * @Version 1.0
 */
public class DataTest {
    public static void main(String[] args) {

        User1 user1 = new User1("moku", 18, 1, "i am moku1");
        User1 user2 = new User1("moku", 18, 2, "i am moku2");

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        // 未使用@EqualsAndHashCode(callSuper = false)注解时，
        //   @Data注解只重写本类(User1)equals方法，未重写父类equals方法
        // true
        System.out.println(user1.equals(user2));

        User2 user11 = new User2("moku", 18, 1, "i am moku1");
        User2 user22 = new User2("moku", 18, 2, "i am moku2");

        System.out.println(user11.hashCode());
        System.out.println(user22.hashCode());
        // 使用@EqualsAndHashCode(callSuper = false)注解时，
        //   @Data注解重写本类(User2)和父类(User)的equals方法
        // false
        System.out.println(user11.equals(user22));
    }
}
