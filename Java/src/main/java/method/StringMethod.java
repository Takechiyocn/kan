package method;

/**
 * @ClassName StringMethod
 * @Description
 * @Author moku
 * @Date 2023/2/16 11:12
 * @Version 1.0
 */
public class StringMethod {

    public static void main(String[] args) {
        // split()
        StringMethod method = new StringMethod();
        method.stringSplit();
    }

    /**
     * 返回一个默认数组
     *   未找到分隔符：返回一个长度为1的数组，数组内容为整个字符串
     *   找到分隔符：返回一个分割个数大小的数组，数组内容为分割后的各个字符串
     * @Params:[]
     * @Returns:void
     */
    public void stringSplit() {
        String str = "123";
        String str2 = "12,3";
        // 1
        System.out.println(str.split(",").length);
        // 2
        System.out.println(str2.split(",").length);
        // 1
        System.out.println("".split(",").length);

    }
}
