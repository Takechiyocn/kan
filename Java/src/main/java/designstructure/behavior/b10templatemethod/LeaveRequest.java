package designstructure.behavior.b10templatemethod;

/**
 * @ClassName LeaveRequest
 * @Description
 * @Author moku
 * @Date 2022/12/25 21:51
 * @Version 1.0
 */
public abstract class LeaveRequest {
    void request() {
        System.out.print("本人");
        System.out.print(name());
        System.out.print("因");
        System.out.print(reason());
        System.out.print("需请假");
        System.out.print(duration());
        System.out.print("天，望批准");
    }

    abstract String name();

    abstract String reason();

    abstract String duration();
}