package designstructure.behavior.b10templatemethod;

/**
 * @ClassName MyLeaveRequest
 * @Description
 * @Author moku
 * @Date 2022/12/25 21:52
 * @Version 1.0
 */
public class MyLeaveRequest extends LeaveRequest {
    @Override
    String name() {
        return "moku";
    }

    @Override
    String reason() {
        return "生病";
    }

    @Override
    String duration() {
        return "0.5";
    }
}
