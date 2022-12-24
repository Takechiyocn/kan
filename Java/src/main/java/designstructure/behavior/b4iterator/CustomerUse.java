package designstructure.behavior.b4iterator;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/25 1:32
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        MyList list = new MyList();
        // 获取自定义迭代器
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
