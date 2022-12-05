package io.nio;

import java.nio.ByteBuffer;

/**
 * @ClassName BufferRWDirectly
 * @Description flip、读、写均会影响Buffer的核心变量(limit,position,mark)
 * @Author moku
 * @Date 2022/12/5 10:24
 * @Version 1.0
 */
public class BufferRWDirectly {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 初始化时候核心变量值
        System.out.println("初始值 capacity：" + byteBuffer.capacity());
        System.out.println("初始值 limit：" + byteBuffer.limit());
        System.out.println("初始值 position：" + byteBuffer.position());
        System.out.println("初始值 mark：" + byteBuffer.mark());

        // 添加数据到缓冲区
        String s = "Hello world!";
        byteBuffer.put(s.getBytes());

        // 添加数据后核心变量值
        System.out.println("添加后 capacity：" + byteBuffer.capacity());
        System.out.println("添加后 limit：" + byteBuffer.limit());
        System.out.println("添加后 position：" + byteBuffer.position());
        System.out.println("添加后 mark：" + byteBuffer.mark());

        // 更改limit(数据)和position值(指针指到缓存头部)
        byteBuffer.flip();

        // 添加数据后核心变量值
        System.out.println("flip后 capacity：" + byteBuffer.capacity());
        System.out.println("flip后 limit：" + byteBuffer.limit());
        System.out.println("flip后 position：" + byteBuffer.position());
        System.out.println("flip后 mark：" + byteBuffer.mark());

        // 创建一个limit()大小的字节数组(因为就只有limit这么多个数据可读)
        byte[] bytesTo = new byte[byteBuffer.limit()];

        // 将读取的数据装进我们的字节数组中
        byteBuffer.get(bytesTo);

        System.out.println(new String(bytesTo, 0, bytesTo.length));
    }
}
