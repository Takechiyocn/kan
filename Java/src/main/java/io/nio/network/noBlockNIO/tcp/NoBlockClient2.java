package io.nio.network.noBlockNIO.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @ClassName NoBlockClient
 * @Description
 * @Author moku
 * @Date 2022/12/6 21:17
 * @Version 1.0
 */
public class NoBlockClient2 {
    public static void main(String[] args) throws IOException {

        // 1. 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));

        // 1.1 切换成非阻塞模式
        socketChannel.configureBlocking(false);

        // 1.2 获取选择器
        Selector selector = Selector.open();

        // 1.3 将通道注册到选择其中，获取服务端返回的数据
        socketChannel.register(selector, SelectionKey.OP_READ);

        // 2. 获取本地文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get("src/main/java/io/nio/network/noBlockNIO/tcp/file/client/noBlockNIO.txt"), StandardOpenOption.READ);

        // 3. 获取非直接缓存
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 4. 获取本地文件
        while (fileChannel.read(buf) != -1) {
            // 读之前切换成读模式
            buf.flip();
            socketChannel.write(buf);
            // 读完切换成写模式，让管道继续读取文件数据
            buf.clear();
        }

        // 5. 轮询获取选择器上已就绪事件
        while (selector.select() > 0) {
            // 6. 获取当前选择器上所有注册的"选择键"(已就绪的监听事件)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            // 7. 获取已就绪事件
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                // 8. 读事件就绪
                if (selectionKey.isReadable()) {
                    // 8.1 获取当前选择器读就绪状态的通道
                    SocketChannel channel = (SocketChannel) selectionKey.channel();

                    // 8.1 非直接缓存
                    ByteBuffer resBuf = ByteBuffer.allocate(1024);

                    // 8.2 读取服务端响应的数据
                    int rBytes = channel.read(resBuf);
                    if (rBytes > 0) {
                        resBuf.flip();
                        System.out.println("Received msg from server:" + new String(resBuf.array(),0, rBytes));
                        resBuf.clear();
                    }
                }
                // 9. 取消选择键(取消掉处理完毕事件)
                iterator.remove();
            }
        }

        // 10. 关闭流
        fileChannel.close();
        socketChannel.close();
    }
}
