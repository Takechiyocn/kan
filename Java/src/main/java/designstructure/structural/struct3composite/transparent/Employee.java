package designstructure.structural.struct3composite.transparent;

/**
 * @ClassName Employee
 * @Description
 * @Author moku
 * @Date 2022/12/22 18:02
 * @Version 1.0
 */
public class Employee extends Component {
    public Employee(String position, String job) {
        super(position, job);
    }

    @Override
    public void addComponent(Component component) {
        System.out.println("职员没有管理权限");
    }

    @Override
    public void removeComponent(Component component) {
        System.out.println("职员没有管理权限");
    }

    @Override
    public void check() {
        work();
    }
}
