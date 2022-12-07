package io.nio.network.noBlockNIO.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName UdpNioClient
 * @Description
 * @Author moku
 * @Date 2022/12/7 12:33
 * @Version 1.0
 */
public class UdpNioClient {
    public static void main(String[] args) throws IOException {

        // 1. 获取通道
        DatagramChannel dc = DatagramChannel.open();

        // 1.1 切换成非阻塞模式
        dc.configureBlocking(false);

        // 2. 获取非直接缓存
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 3. 输入流
        Scanner scan = new Scanner(System.in);

        // 4. 获取输入流
        while (scan.hasNext()) {
            String s = scan.next();
            buf.put((new Date().toString() + ":\n" + s).getBytes());
            buf.flip();
            // 发送数据报
            dc.send(buf, new InetSocketAddress("127.0.0.1", 9898));
            buf.clear();
        }

        // 6. 关闭通道
        dc.close();
    }
}
