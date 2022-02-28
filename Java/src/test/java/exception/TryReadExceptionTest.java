package exception;


/**
 * @description:
 * @author: Kan
 * @date: 2021/3/5 0:57
 */
public class TryReadExceptionTest {

    public static void main(String[] args) {

        TryReadException r = new TryReadException();

        // 返回当前Class这个类所在包开始的为置
        System.out.println(TryReadExceptionTest.class.getResource("").getPath());
        // 返回的是classpath的位置
        System.out.println(TryReadExceptionTest.class.getResource("/").getPath());
        // 相对路径
        r.read(System.getProperty("user.dir") + "/fileHandler.loga");
    }
}
