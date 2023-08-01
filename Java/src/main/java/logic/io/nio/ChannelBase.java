package logic.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ClassName ChannelBase
 * @Description 获取channel
 *              1. 通过本地IO
 *              2. JDK1.7后通过静态方法open()
 * @Author moku
 * @Date 2022/12/5 10:48
 * @Version 1.0
 */
public class ChannelBase {

    public static void main(String[] args) throws IOException {

        // 1. 通过本地IO的方式获取通道
        FileInputStream fis = new FileInputStream("src/main/java/io/nio/file/fis.txt");
        // 得到文件的输入通道
        FileChannel inChannel = fis.getChannel();

        // 2. JDK1.7后通过静态方法open()获取通道
        FileChannel inChannel2 = FileChannel.open(Paths.get("src/main/java/io/nio/file/fis.txt"), StandardOpenOption.WRITE);
    }
}
