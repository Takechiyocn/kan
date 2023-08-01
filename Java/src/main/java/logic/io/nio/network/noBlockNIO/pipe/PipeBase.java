package logic.io.nio.network.noBlockNIO.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @ClassName PipeBase
 * @Description
 * @Author moku
 * @Date 2022/12/7 13:36
 * @Version 1.0
 */
public class PipeBase {
    public static void main(String[] args) throws IOException {

        // 1. 获取管道
        Pipe pipe = Pipe.open();

        // 2. 获取缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 3. 将缓冲区数据写入管道
        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("Hello World!".getBytes());
        buf.flip();
        sinkChannel.write(buf);

        // 4. 读取管道数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        int len = sourceChannel.read(buf2);
        System.out.println(new String(buf2.array(), 0, len));

        // 5. 关闭管道
        sinkChannel.close();
        sourceChannel.close();
    }
}
