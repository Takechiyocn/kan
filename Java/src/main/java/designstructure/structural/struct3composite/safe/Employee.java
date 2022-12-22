package designstructure.structural.struct3composite.safe;

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
    public void check() {
        work();
    }
}
