package designstructure.structural.struct7proxy.interfaces;

/**
 * @ClassName IHttp
 * @Description 请求接口
 * @Author moku
 * @Date 2022/12/22 23:14
 * @Version 1.0
 */
public interface IHttp {
    void request(String sendData);
    void onSuccess(String receivedData);
}
