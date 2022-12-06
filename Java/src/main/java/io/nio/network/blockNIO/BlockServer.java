package io.nio.network.blockNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ClassName BlockServer
 * @Description
 * @Author moku
 * @Date 2022/12/6 20:25
 * @Version 1.0
 */
public class BlockServer {
    public static void main(String[] args) throws IOException {

        // 1. 获取网络文件通道
        ServerSocketChannel server = ServerSocketChannel.open();

        // 2. 获取本地文件通道
        FileChannel outChannel = FileChannel.open(Paths.get("src/main/java/io/nio/network/blockNIO/file/server/blockNIO.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        // 3. 绑定连接
        server.bind(new InetSocketAddress(6666));

        // 4. 获取客户端连接(阻塞的)
        SocketChannel client = server.accept();

        // 5. 缓存
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 6. 读取客户端发送的文件
        while (client.read(buf) != -1) {
            // 读之前切换成读模式
            buf.flip();
            outChannel.write(buf);
            // 读完切换成写模式，让管道继续读取文件数据
            buf.clear();
        }

        // 7. 服务端成功接收文件后，通知客户端，文件上传成功
        buf.put("file transfer success".getBytes());
        buf.flip();
        client.write(buf);
        buf.clear();

        // 8. 关闭通道
        outChannel.close();
        client.close();
        server.close();
    }
}
