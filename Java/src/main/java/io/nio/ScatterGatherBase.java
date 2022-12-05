package io.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName ScatterGatherBase
 * @Description 分散读取、聚集写入
 * @Author moku
 * @Date 2022/12/5 11:57
 * @Version 1.0
 */
public class ScatterGatherBase {
    public static void main(String[] args) throws IOException {

        File source = new File("C:\\Workspace\\tmp\\NIO-copy\\100mb.mp4");
        File des = new File("C:\\Workspace\\tmp\\NIO-copy\\100mb-1.mp4");
        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(des,"rw");

        // 创建通道
        FileChannel inChannel = read.getChannel();
        FileChannel outChannel = write.getChannel();

//        ByteBuffer buf1 = ByteBuffer.allocate(1024);
//        ByteBuffer buf2 = ByteBuffer.allocate(1024 * 2);

        // 分配指定大小的缓冲区：匿名数组
        ByteBuffer[] bufs = {
                ByteBuffer.allocate(1024),
                ByteBuffer.allocate(1024 * 2)
        };

        // 分散读取
        inChannel.read(bufs);
        for (ByteBuffer buf : bufs) {
            buf.flip();
        }
        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        // 聚集写入
        outChannel.write(bufs);

        inChannel.close();
        outChannel.close();
    }

}
