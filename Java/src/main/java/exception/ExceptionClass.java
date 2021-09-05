package exception;

/**
 * TODO：将受查异常包装为非受查异常
 */
public class ExceptionClass {
    public static void main(String[] args) {
        try {
            String name = "occupation.Employee";
            Class cls = Class.forName(name);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
