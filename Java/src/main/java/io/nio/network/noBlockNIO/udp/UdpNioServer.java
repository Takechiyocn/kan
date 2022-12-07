package io.nio.network.noBlockNIO.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * @ClassName UdpNioServer
 * @Description
 * @Author moku
 * @Date 2022/12/7 13:22
 * @Version 1.0
 */
public class UdpNioServer {
    public static void main(String[] args) throws IOException {

        // 1. 获取通道
        DatagramChannel dc = DatagramChannel.open();

        // 1.2 切换成费阻塞模式
        dc.configureBlocking(false);

        // 2. 绑定连接
        dc.bind(new InetSocketAddress(9898));

        // 3. 获取选择器
        Selector selector = Selector.open();

        // 4. 将通道注册到选择器，指定接收"监听通道"事件
        dc.register(selector, SelectionKey.OP_READ);

        // 5. 轮询获取选择器上已"就绪"的事件
        while (selector.select() > 0) {
            // 6. 获取当前选择器上所有注册的"选择键"(已就绪的监听事件)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isReadable()) {
                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    dc.receive(buf);
                    buf.flip();
                    System.out.println(new String(buf.array(), 0, buf.limit()));
                    buf.clear();
                }
                iterator.remove();
            }
        }
    }
}
