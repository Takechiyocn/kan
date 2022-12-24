package designstructure.behavior.b1chainofresponsibility;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/24 18:08
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {
        NewbieProgrammer newbie = new NewbieProgrammer();
        NormalProgrammer normal = new NormalProgrammer();
        ProfessionalProgrammer pro = new ProfessionalProgrammer();

        Bug easy = new Bug(20);
        Bug middle = new Bug(50);
        Bug hard = new Bug(100);

        // 设置责任链
        newbie.setNext(normal);
        normal.setNext(pro);

        // 从新手程序员开始，沿着责任链传递
        newbie.handle(easy);
        newbie.handle(middle);
        newbie.handle(hard);
    }
}
