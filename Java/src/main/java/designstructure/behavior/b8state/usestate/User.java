package designstructure.behavior.b8state.usestate;

import designstructure.behavior.b8state.IUser;
import designstructure.behavior.b8state.ISwitchState;

/**
 * @ClassName User
 * @Description
 * @Author moku
 * @Date 2022/12/25 11:00
 * @Version 1.0
 */
public class User implements IUser, ISwitchState {
    IUser state = new Normal();

    @Override
    public void mockInterview() {
        state.mockInterview();
    }

    @Override
    public void purchasePlus() {
        state = new Plus();
    }

    @Override
    public void expire() {
        state = new Normal();
    }
}
