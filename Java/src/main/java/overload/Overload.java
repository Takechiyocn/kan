package overload;

import java.util.*;


/**
 * 重载，[静态分配]: 参数匹配看实参定义(等号)的左边。
 * 重写，[动态分派]: 调用谁的方法，看对象定义的右边。
 *
 * Java多态：
 *   编译时多态：重载
 *   运行时多态：重写
 * Parent p = new Son(); // Son extends Parent;
 * 静态方法：编译和运行都调用父类版本->静态多分派
 * 普通方法：编译调用父类版本，运行调用子类版本(动态绑定)->动态单分派
 * 成员变量：编译和运行都调用父类版本(参考左边)
 */
public class Overload {
    public static void main(String[] args) {
        Collection<?>[] collections =
                {new HashSet<String>(), new ArrayList<String>(), new HashMap<String, String>().values()};
        // 静态类型是Super，实际类型是Sub：左边是静态类型/编译类型，右边是实际类型/运行时类型
        Super subToSuper = new Sub();
        // 类似于Collection col = new HashSet<>()传参，静态类型为Collection
        for (Collection<?> collection : collections) {
            // 重载是根据形参的静态类型确定调用的方法版本
            System.out.println(subToSuper.getType(collection));
        }
    }

    abstract static class Super {
        public static String getType(Collection<?> collection) {
            return "Super:collection";
        }

        public static String getType(List<?> list) {
            return "Super: list";
        }

        public String getType(ArrayList<?> list) {
            return "Super: arrayList";
        }

        public static String getType(Set<?> set) {
            return "Super: set";
        }

        public String getType(HashSet<?> set) {
            return "Super: hashSet";
        }
    }

    static class Sub extends Super {
        // 静态方法不能被重写，同名方法，此处方法不是重写，是和父类完全相同的函数
        public static String getType(Collection<?> collection) {
            return "Sub";
        }
    }
}
