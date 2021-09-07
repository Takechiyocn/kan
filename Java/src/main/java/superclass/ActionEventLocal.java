package superclass;

import java.awt.event.ActionEvent;
import java.util.function.Supplier;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/1 0:09
 */
public class ActionEventLocal {

    /**
     * lambda表达式用
     * ActionListener必须要有监听对象（ActionEvent），所有super的greet方法必须有该参数
     * @param actionEvent
     */
    public void greet(ActionEvent actionEvent)  {
        System.out.println("Hello, world! Event:" + actionEvent);
    }

    public void greet2(Supplier<String> msg, ActionEvent actionEvent)  {
        System.out.println("Hello, world! Event:" + actionEvent);
    }
}
