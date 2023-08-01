package logic.container.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorExceptionAvoid {
    public static void main(String[] args) {
        //创建集合对象
        List list = new ArrayList();

        //添加对象
        list.add("hello");
        list.add("world");
        list.add("java");

        // 迭代器遍历
        // 迭代器异常：迭代器是依赖于集合而存在的，在判断成功之后，集合当中增加了新的元素，而迭代器却不知道，称为并发修改异常
//        Iterator it = list.iterator();
//        while(it.hasNext()){
//            String string = (String) it.next();
//            // ConcurrentModificationException
//            if(string.equals("world")){
//                // 使用结合进行结构性修改
//                list.add("javaee");
//            }
//        }

        // 解决方案1：迭代器迭代元素，迭代器修改元素，即使用迭代器进行结构性修改(元素增加)
        ListIterator lit = list.listIterator();
        while (lit.hasNext()) {
            String string = (String) lit.next();
            if (string.equals("world")) {
                // 使用迭代器修改元素，而非集合直接修改
                lit.add("javaee");
            }
        }

        // 解决方案2：集合遍历元素，集合修改元素（标准for循环）：使用集合进行结构性修改，即元素跟在集合最后一个元素之后。
        for (int i = 0; i < list.size(); i++) {
            String s = (String) list.get(i);
            if (s.equals("world")) {
                // 使用集合进行结构性修改
                list.add("javaee2");
            }
        }

        System.out.println("list:"+list);
    }
}
