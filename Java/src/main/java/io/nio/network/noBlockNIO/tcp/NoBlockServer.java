package io.nio.network.noBlockNIO.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @ClassName NoBlockServer
 * @Description
 * @Author moku
 * @Date 2022/12/7 1:52
 * @Version 1.0
 */
public class NoBlockServer {
    public static void main(String[] args) throws IOException {

        // 1. 获取网络文件通道
        ServerSocketChannel server = ServerSocketChannel.open();

        // 2. 切换成非阻塞模式
        server.configureBlocking(false);

        // 3. 绑定连接
        server.bind(new InetSocketAddress(6666));

        // 4. 获取选择器
        Selector selector = Selector.open();

        // 4.1 将通道注册到选择器，指定接收"监听通道"事件
        server.register(selector, SelectionKey.OP_ACCEPT);

        // 5. 轮询获取选择器上已"就绪"的事件
        while (selector.select() > 0) {
            // 6. 获取当前选择器上所有注册的"选择键"(已就绪的监听事件)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            // 7. 获取已就绪事件
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 接收事件就绪
                if (selectionKey.isAcceptable()) {
                    // 8. 获取客户端连接
                    SocketChannel client = server.accept();

                    // 8.1 客户端连接切换成非阻塞模式
                    client.configureBlocking(false);

                    // 8.2 客户端通道注册到选择器(客户端连接是为了读取通道数据，即监听就绪事件)
                    client.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    // 9. 获取当前选择器读就绪状态的通道
                    SocketChannel client = (SocketChannel) selectionKey.channel();

                    // 9.1 非直接缓存
                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    // 9.2 获取本地文件通道
                    FileChannel outChannel = FileChannel.open(Paths.get("src/main/java/io/nio/network/noBlockNIO/tcp/file/server/noBlockNIO.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

                    // 9.3 读取文件
                    while (client.read(buf) > 0) {
                        // 读之前切换成读模式
                        buf.flip();
                        outChannel.write(buf);
                        // 读完切换成写模式，让管道继续读取文件数据
                        buf.clear();
                    }

                    // 9.4. 服务端成功接收文件后，通知客户端，文件上传成功
                    buf.put("file transfer success".getBytes());
                    buf.flip();
                    client.write(buf);
                    buf.clear();

                    // 9.5 关闭流
//                    outChannel.close();
                }
                // 10. 取消选择键(取消掉处理完毕事件)
                iterator.remove();
            }
        }

        // 11. 关闭流
        server.close();
    }
}
