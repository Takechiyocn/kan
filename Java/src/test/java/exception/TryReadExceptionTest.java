package exception;


/**
 * @description:
 * @author: Kan
 * @date: 2021/3/5 0:57
 */
public class TryReadExceptionTest {

    public static void main(String[] args) {

        TryReadException r = new TryReadException();
        r.read("test");
    }
}
