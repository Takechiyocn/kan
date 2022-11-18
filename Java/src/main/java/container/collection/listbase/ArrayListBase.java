package container.collection.listbase;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组列表ArrayList：封装了动态分配的对象数组
 * 动态数组：也可使用Vector
 * 特点：1.Vector类的所有方法都是同步(synchronized同步处理)
 *        数组列表方法不同步
 *      2. Vector:可以由两个线程安全访问一个Vector对象
 *                如果由一个线程访问Vector，代码同步操作需要耗费大量时间
 *  使用条件：需要同步时使用Vector
 *           不需要同步时使用数组列表
 *
 * @author moku
 */
public class ArrayListBase {

    public static void main(String[] args) {
        List<String> all = new ArrayList<>() {{
            add("one sheep");
            add("one sheep");
            add("two sheep");
        }};
        System.out.println("Elements in list:" + all.size());
        all.remove("two sheep");
        System.out.println("Elements in list after remove:" + all.size());
        // 获取指定索引元素
        System.out.println("Index i:" + all.get(1));
        System.out.println(all);
    }
}
