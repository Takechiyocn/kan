package designstructure.creational.factory2factorymethod.implement;

import designstructure.creational.factory2factorymethod.absclazz.Computer;

/**
 * @ClassName MacComputer
 * @Description 2.定义具体对象类
 * @Author moku
 * @Date 2022/12/18 19:19
 * @Version 1.0
 */
public class MacComputer extends Computer {
    @Override
    public void setOperationSystem() {
        System.out.println("Mac笔记本安装Mac系统");
    }
}
