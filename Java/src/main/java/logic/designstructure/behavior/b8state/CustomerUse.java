package logic.designstructure.behavior.b8state;

import logic.designstructure.behavior.b8state.usestate.User;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/25 11:05
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        // 普通会员：无面试功能
        User user = new User();
        user.mockInterview();

        // 升级为plus会员：有面试功能
        user.purchasePlus();
        user.mockInterview();

        // 会员过期：无面试功能
        user.expire();
        user.mockInterview();
    }
}
