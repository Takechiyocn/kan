package designstructure.behavior.b1chainofresponsibility;

/**
 * @ClassName Programmer
 * @Description
 * @Author moku
 * @Date 2022/12/24 17:58
 * @Version 1.0
 */
public abstract class Programmer {
    protected Programmer next;

    // 传递链
    public void setNext(Programmer next) {
        this.next = next;
    }

    // 处理逻辑：自己解决或者继续传递
    abstract void handle(Bug bug);
}
