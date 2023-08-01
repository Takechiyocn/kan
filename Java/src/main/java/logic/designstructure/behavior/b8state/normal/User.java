package logic.designstructure.behavior.b8state.normal;

import logic.designstructure.behavior.b8state.ISwitchState;
import logic.designstructure.behavior.b8state.IUser;

/**
 * @ClassName User
 * @Description
 * @Author moku
 * @Date 2022/12/25 10:53
 * @Version 1.0
 */
public class User implements IUser, ISwitchState {
    private State state = State.NORMAL;

    // 当用户接口有多个功能时，必须同时更改接口和接口实现
    @Override
    public void mockInterview() {
        if (state == State.PLUS) {
            System.out.println("开始模拟面试");
        } else {
            System.out.println("模拟面试时Plus会员专属功能");
        }
    }

    @Override
    public void purchasePlus() {
        state = State.PLUS;
    }

    @Override
    public void expire() {
        state = State.NORMAL;
    }
}
