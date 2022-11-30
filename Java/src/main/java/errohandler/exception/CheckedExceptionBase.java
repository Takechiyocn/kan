package errohandler.exception;

/**
 * TODO：将受查异常包装为非受查异常
 */
public class CheckedExceptionBase {
    public static void main(String[] args) {

        try {
            String name = "occupation.EmployeeNotExist";
            // 受查异常(ClassNotFoundException)
            Class cls = Class.forName(name);
        }
        catch(Exception e) { // 声明/捕获受查异常
            e.printStackTrace();
        }
    }
}
