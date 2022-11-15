package container.collection.listbase;

/**
 * 数组列表ArrayList：封装了动态分配的对象数组
 * 动态数组：也可使用Vector
 * 特点：1.Vector类的所有方法都是同步
 *        数组列表方法不同步
 *      2. Vector:可以由两个线程安全访问一个Vector对象
 *                如果由一个线程访问Vector，代码同步操作需要耗费大量时间
 *  使用条件：需要同步时使用Vector
 *           不需要同步时使用数组列表
 *
 */
public class ArrayListBase {
}
