package io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @ClassName CharacterEncodeBase
 * @Description 编码解码
 * @Author moku
 * @Date 2022/12/6 12:37
 * @Version 1.0
 */
public class CharacterEncodeBase {
    public static void main(String[] args) throws CharacterCodingException {

        Charset cs = Charset.forName("GBK");

        // 获取编码器
        CharsetEncoder ce = cs.newEncoder();
        // 获取解码器
        CharsetDecoder cd = cs.newDecoder();

        // 非直接缓冲区
        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("中国人");
        cBuf.flip();

        // 编码
        ByteBuffer bBuf = ce.encode(cBuf);
        for (int i = 0; i < 6; i++) {
            System.out.println(bBuf.get());
        }

        // 解码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        for (int i = 0; i < cBuf.limit(); i++) {
            System.out.println(cBuf2.get());
        }
    }
}
