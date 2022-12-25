package designstructure.behavior.b8state.usestate;

import designstructure.behavior.b8state.IUser;

/**
 * @ClassName Normal
 * @Description
 * @Author moku
 * @Date 2022/12/25 10:58
 * @Version 1.0
 */
public class Normal implements IUser {
    @Override
    public void mockInterview() {
        System.out.println("模拟面试是Plus会员专享功能");
    }
}
