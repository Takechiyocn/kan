package logic.designstructure.structural.struct7proxy.interfaces;

/**
 * @ClassName HttpUtil
 * @Description 工具类
 * @Author moku
 * @Date 2022/12/22 23:15
 * @Version 1.0
 */
public class HttpUtil implements IHttp {
    @Override
    public void request(String sendData) {
        System.out.println("网络请求中...");
    }

    @Override
    public void onSuccess(String receivedData) {
        System.out.println("网络请求完成。");
    }
}
