package io.nio.network.noBlockNIO.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ClassName NoBlockClient
 * @Description
 * @Author moku
 * @Date 2022/12/6 21:17
 * @Version 1.0
 */
public class NoBlockClient {
    public static void main(String[] args) throws IOException {

        // 1. 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));

        // 1.1 切换成非阻塞模式
        socketChannel.configureBlocking(false);

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

        // 6. 关闭流
        fileChannel.close();
        socketChannel.close();
    }
}
