package logic.io.nio.network.blockNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ClassName BlockClient
 * @Description
 * @Author moku
 * @Date 2022/12/6 20:15
 * @Version 1.0
 */
public class BlockClient {

    public static void main(String[] args) throws IOException {

        // 1. 获取网络文件通道：客户端的套接字的地址必须要有服务程序(服务端)在监听
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));

        // 2. 获取本地文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get("src/main/java/io/nio/network/blockNIO/file/client/blockNIO.txt"), StandardOpenOption.READ);

        // 3. 获取Buffer
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 4. 读取本地文件，发送到服务器
        while (fileChannel.read(buf) != -1) {
            // 读之前切换成读模式
            buf.flip();
            socketChannel.write(buf);
            // 读完切换成写模式，让管道继续读取文件数据
            buf.clear();
        }

        // 5. 通知服务端数据发送完成(NIO非阻塞模式在此体现，如果不显式通知服务端，服务端会一直阻塞读取数据)
        socketChannel.shutdownOutput();

        // 6. 接收服务端响应的数据
        int len = 0;
        while ((len = socketChannel.read(buf)) != -1) {
            buf.flip();
            System.out.println(new String(buf.array(), 0, len));
            buf.clear();
        }

        // 7. 关闭流
        fileChannel.close();
        socketChannel.close();
    }
}
