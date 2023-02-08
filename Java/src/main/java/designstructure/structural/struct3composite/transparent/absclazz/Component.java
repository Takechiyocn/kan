package designstructure.structural.struct3composite.transparent.absclazz;

/**
 * @ClassName Component
 * @Description
 * @Author moku
 * @Date 2022/12/22 17:54
 * @Version 1.0
 */
public abstract class Component {
    // 职位
    private String position;
    // 工作内容
    private String job;

    public Component(String position, String job) {
        this.position = position;
        this.job = job;
    }

    public void work() {
        System.out.println("我是" + position + "，我正在" + job);
    }

    public abstract void addComponent(Component component);

    public abstract void removeComponent(Component component);

    public abstract void check();
}
