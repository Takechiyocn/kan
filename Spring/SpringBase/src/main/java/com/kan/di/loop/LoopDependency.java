package com.kan.di.loop;

/**
 * @ClassName LoopDependency
 * @Description 强依赖：类在创建之初必须依赖于另一个对象 -> 无法解决
 * @Author moku
 * @Date 2022/12/14 0:39
 * @Version 1.0
 */
public class LoopDependency {
    public static void main(String[] args) {

        new ClazzA();
    }
}

class ClazzA {
    private ClazzB b = new ClazzB();
}

class ClazzB {
    private ClazzA a = new ClazzA();
}
