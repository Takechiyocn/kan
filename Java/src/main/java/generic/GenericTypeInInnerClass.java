package generic;

/**
 *
 * @author moku
 */
public class GenericTypeInInnerClass {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        GenericTypeCommon<String> gt = InnerClass.minmax(words);
        System.out.println("min=" + gt.getFirst());
        System.out.println("max=" + gt.getSecond());
    }
}

/**
 * 内部类实例化泛型函数
 */
class InnerClass {
    public static GenericTypeCommon<String> minmax(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (String s : a) {
            if (min.compareTo(s) > 0) {
                min = s;
            }
            if (max.compareTo(s) < 0) {
                max = s;
            }
        }
        return new GenericTypeCommon<>(min, max);
    }
}