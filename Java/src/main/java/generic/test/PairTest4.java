package generic.test;

import generic.Pair;
import occupation.Manager;

import java.io.File;

/**
 * 泛型类型的继承
 *  1. 参数化类型不存在相互（如继承）关系
 *  2. 参数化类型只与原始类型或通配符类型存在相互关系
 *
 * TODO：泛型类扩展ArrayList<T>
 */
public class PairTest4 {

    public static void main(String[] args) {
        Manager ceo = new Manager("ceo",11,1990,1,1);
        Manager cfo = new Manager("cfo",11,1990,1,1);

        Pair<Manager> managerPair = new Pair<>(ceo, cfo);
        // 永远可以将**参数化类型(如Pair<Employee>)**转换为一个原始类型Pair
        // 因为参数化类型是原始类型的子类型
        Pair rawBuddies = managerPair;
        // 产生一个编译警告
        // 能调用原因：类型擦除后参数化类型和原始类型均为Object类型，因此可以转换
        rawBuddies.setFirst(new File("test"));
        // 运行时错误：类型转换错误ClassCastException
        Manager other = (Manager)rawBuddies.getFirst();
    }
}
