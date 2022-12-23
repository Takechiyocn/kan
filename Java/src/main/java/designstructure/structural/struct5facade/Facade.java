package designstructure.structural.struct5facade;

import designstructure.structural.struct5facade.bean.Browser;
import designstructure.structural.struct5facade.bean.IDE;
import designstructure.structural.struct5facade.bean.WeChat;

/**
 * @ClassName Facade
 * @Description
 * @Author moku
 * @Date 2022/12/23 18:44
 * @Version 1.0
 */
public class Facade {
    public void open(){
        Browser.open();
        IDE.open();
        WeChat.open();
    }

    public void close(){
        Browser.close();
        IDE.close();
        WeChat.close();
    }
}
