package designstructure.behavior.b11visitor;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/25 22:07
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        Restaurant r = new Restaurant();
        IVisitor v = new CustomerA();
        IVisitor v2 = new CustomerB();
        r.welcome(v);
        r.welcome(v2);
    }
}
