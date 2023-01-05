package io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ClassName FileCopyNIO
 * @Description BIO/NIO文件复制
 * @Author moku
 * @Date 2022/12/5 9:22
 * @Version 1.0
 */
public class FileCopyNIO {
    public static void main(String[] args) throws IOException {

        File source = new File("C:\\Workspace\\tmp\\NIO-copy\\100mb.mp4");
        File bio = new File("C:\\Workspace\\tmp\\NIO-copy\\100mb.BIO.mp4");
        File nioLocal1 = new File("C:\\Workspace\\tmp\\NIO-copy\\100mb.NIO1.mp4");
        File nioLocal2 = new File("C:\\Workspace\\tmp\\NIO-copy\\100mb.NIO2.mp4");
        String strSource = "C:\\Workspace\\tmp\\NIO-copy\\100mb.mp4";
        String strDes = "C:\\Workspace\\tmp\\NIO-copy\\100mb.NIO3.mp4";
        String strDes2 = "C:\\Workspace\\tmp\\NIO-copy\\100mb.NIO4.mp4";


        // BIO复制文件
        long timeBio = transferFile(source, bio);
        System.out.println(timeBio + "：传统IO时间");

        // NIO复制文件1：FileInputStream
        long timeNio1 = transferFileWithNIOLocal1(source, nioLocal1);
        System.out.println(timeNio1 + "：NIO(InputStreamFile)时间");

        // NIO复制文件2：RandomAccessFile
        long timeNio2 = transferFileWithNIOLocal2(source, nioLocal2);
        System.out.println(timeNio2 + "：NIO(RandomAccessFile)时间");

        // NIO复制文件3：内存映射文件(直接缓冲区1)
        long timeNio3 = transferFileByDirectMemory1(strSource, strDes);
        System.out.println(timeNio3 + "：NIO(直接内存)时间");

        // NIO复制文件4：直接缓冲区操作 -> 速度最快
        long timeNio4 = transferFileByDirectMemory2(strSource, strDes2);
        System.out.println(timeNio4 + "：NIO(直接内存2)时间");
    }

    private static long transferFileByDirectMemory2(String source, String des) throws IOException {
        long startTime = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get(source), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get(des), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.TRUNCATE_EXISTING);

        // 直接缓存操作
        inChannel.transferTo(0, inChannel.size(), outChannel);

        inChannel.close();
        outChannel.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long transferFileByDirectMemory1(String source, String des) throws IOException {
        long startTime = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get(source), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get(des), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.TRUNCATE_EXISTING);

        // 内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        // 直接对缓冲区进行数据的读写操作
        byte[] b = new byte[inMappedBuf.limit()];
        inMappedBuf.get(b);
        outMappedBuf.put(b);
        System.out.println("直接缓冲区？：" + inMappedBuf.isDirect());

        inChannel.close();
        outChannel.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long transferFileWithNIOLocal2(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();

        if (!des.exists()) {
            des.createNewFile();
        }

        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(des, "rw");
        // 读写channel
        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();
        // 读写buffer：非直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
        System.out.println("直接缓冲区？：" + byteBuffer.isDirect());

        // 多线程读取同一文件，可加锁
        FileLock readChannelLock = readChannel.lock();
        // pos和siz决定加锁区域， shared指定是否是共享锁
//        FileLock readChannelLock = readChannel.lock(pos, size, shared);
//        if (readChannelLock!=null) {
//        }
        while (readChannel.read(byteBuffer) > 0) {
            // 切换称读数据模式：设置读指针到缓存头部
            byteBuffer.flip();
            // 将缓冲区数据写入通道
            writeChannel.write(byteBuffer);
            // 清空缓冲区
            byteBuffer.clear();
        }

        readChannel.close();
        writeChannel.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long transferFileWithNIOLocal1(File source, File des) {
        long startTime = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        // 获取通道
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream(source);
            fos = new FileOutputStream(des);
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            // 分配指定大小缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);

            System.out.println("直接缓冲区？：" + byteBuffer.isDirect());

            // 写缓冲区：从(输入)通道将数据写入缓冲区
            while (inChannel.read(byteBuffer) > 0) {
                byteBuffer.flip();
                // 读缓冲区：将缓冲区数据写入(输出)通道
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long transferFile(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();

        if (!des.exists()) {
            des.createNewFile();
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        // 一次读取固定大小数据
        byte[] bytes = new byte[1024 * 1024];
        int len;
        while((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bis.close();
        bos.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
