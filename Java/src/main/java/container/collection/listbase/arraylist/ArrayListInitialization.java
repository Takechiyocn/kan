package container.collection.listbase.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * 数组和数组列表区别：
 *   数组：
 *     Array的空间大小是固定的，空间不够时也不能再次申请
 *     Array数组可以包含基本类型和对象类型
 *     保存一些在整个程序运行期间都会存在而且不变的数据，我们可以将它们放进一个全局数组里
 *   数组列表：
 *     ArrayList的空间是动态增长的，如果空间不够，它会创建一个空间比原空间大0.5倍的新数组，然后将所有元素复制到新数组中，接着抛弃旧数组
 *     ArrayList却只能包含对象类型
 *     单纯只是想要以数组的形式保存数据，而不对数据进行增加等操作，只是方便我们进行查找
 *     元素进行频繁的移动或删除，或者处理的是超大量的数据，可选择LinkedList
 * @author: Kan
 * @date: 2021/3/1 0:38
 */
public class ArrayListInitialization {
    // constructor
    public ArrayListInitialization() {
    }
    // 数组列表只是表明该数组列表拥有保存10个元素的潜力（实际重新分配空间将会超过100）
    // 未用add等方法追加元素前，数组列表中包含的实际元素数目为0
    ArrayList<String> arrayList = new ArrayList<>(10);
//    System.out.println("声明数组列表后，数组列表未分配空间，即size=" + arrayList.size());
    // 如果能确定数组可能存储的元素数量，可用ensureCapacity方法
//    arrayList.ensureCapacity(100);
    // 如果确定数组列表的大小不再发生变化，可用trimToSize方法调整存储区域大小
    // 垃圾回收器将回收多余的存储空间
//    arrayList.trimToSize();

    // 1. ArrayList<T>(Arrays.asList(arrays))
    public static ArrayList<String> initialArrayList() {
        // Arrays.asList返回原数组支持的固定大小的列表
        // 将Arrays.asList作为new ArrayList参数可解除这种限制
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        System.out.println(arrayList.size());
        // 可增加list元素
        arrayList.add("D");
        System.out.println(arrayList.size());
        return arrayList;
//        return new ArrayList<>(Arrays.asList("A", "B", "C"));
    }

    // 2. new ArrayList<String>();
    //   add
    public static ArrayList<String> initialArrayList2() {
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("A");
        arrayList2.add("B");
        arrayList2.add("C");
        return arrayList2;
    }

    // 3. new ArrayList<String>(){{add("A")}};
    // 匿名数组列表
    public static ArrayList<String> initialArrayList3() {
        ArrayList<String> arrayList3 = new ArrayList<>() {{
            add("A");
            add("B");
            add("C");
        }};
        return arrayList3;
    }

    public static void main(String[] args) {
        initialArrayList();
    }
}

