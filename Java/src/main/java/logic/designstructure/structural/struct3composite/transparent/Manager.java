package logic.designstructure.structural.struct3composite.transparent;

import logic.designstructure.structural.struct3composite.transparent.absclazz.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Manager
 * @Description
 * @Author moku
 * @Date 2022/12/22 17:56
 * @Version 1.0
 */
public class Manager extends Component {
    private List<Component> components = new ArrayList<>();

    public Manager(String position, String job) {
        super(position, job);
    }

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public void check() {
        work();
        // 检查下属
        for (Component c : components) {
            c.check();
        }
    }
}
