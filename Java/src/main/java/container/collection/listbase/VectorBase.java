package container.collection.listbase;

import java.util.Vector;

/**
 * @ClassName VectorBase
 * @Description 实现一个动态数组
 * @Author moku
 * @Date 2022/11/24 9:47
 * @Version 1.0
 */
public class VectorBase {

    public static void main(String[] args) {

        // 初始化
        vectorInit();

        // 增
        vectorAdd();

        // 删
        vectorRemove();

        // 改
        vectorModify();

        // 查
        vectorIndex();

        // 遍历

    }

    /**
     * elementAt(index)
     * indexOf(obj)
     * contains(obj)
     * @Params:   []
     * @Returns:  void
     */
    private static void vectorIndex() {
        Vector v = new Vector() {{
            addElement("a");
            addElement("b");
            addElement("c");
        }};
        System.out.println("Vector index:" + v);

        // 返回指定位置元素
        String str = (String)v.elementAt(1);
        System.out.println("Vector search by index:" + str);

        // 返回指定元素index
        System.out.println("Vector specified obj, index=" + v.indexOf("2"));

        // 检查序列包含指定元素
        System.out.println("Vector contains obj:" + v.contains("c"));
    }

    /**
     * setElementAt(obj, index)
     * @Params:   []
     * @Returns:  void
     */
    private static void vectorModify() {
        Vector v = new Vector() {{
            addElement("AA");
            addElement("BB");
        }};
        System.out.println("Vector before modify:" + v);

        // 修改指定位置元素
        v.setElementAt("aa", 0);
        v.setElementAt("bb", 1);
        System.out.println("Vector after modify:" + v);
    }

    /**
     * removeElement(obj)
     * removeElement(index)
     * removeAllElement()
     * @Params:   []
     * @Returns:  void
     */
    private static void vectorRemove() {
        Vector v = new Vector() {{
            addElement(1);
            addElement(2);
            addElement(3);
            addElement(4);
        }};
        System.out.println("Vector before remove:" + v);

        // 直接删除object
        v.removeElement(1);
        System.out.println("Vector remove by obj:" + v);

        // 删除index
        v.removeElementAt(1);
        System.out.println("Vector remove by index:" + v);

        // 删除全部
        v.removeAllElements();
        System.out.println("Vector remove all:" + v);
    }

    /**
     * addElement(obj)
     * insertElementAt(obj, index)
     * @Params:   [] object
     * @Returns:  void
     */
    private static void vectorAdd() {
        // 添加到尾部
        Vector v = new Vector();
        v.addElement("A");
        v.addElement("B");
        v.addElement("C");

        // 添加到置定位(index从0开始)
        v.insertElementAt("A0",0);

        System.out.println("Vector add: " + v);
    }

    /**
     * new Vector()
     * new Vector(initialCapacity)
     * new Vector(initialCapacity, capacityIncrement)
     * @Params:   []
     * @Returns:  void
     */
    private static void vectorInit() {
        // 不指定初始容量：默认10
        Vector<Object> v = new Vector<>();
        // 指定初始容量：3
        Vector<Object> v2 = new Vector<>(3);
        // 指定初始容量：3、增长因子：2
        Vector<Object> v3 = new Vector<>(3, 2);

        System.out.println("Vector initialization size: " + v.size() + ", capacity: " + v.capacity());
        System.out.println("Vector initialization size: " + v2.size() + ", capacity: " + v2.capacity());
        System.out.println("Vector initialization size: " + v3.size() + ", capacity: " + v3.capacity());
    }
}
