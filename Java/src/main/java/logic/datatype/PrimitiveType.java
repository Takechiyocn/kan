package logic.datatype;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author moku
 */
public class PrimitiveType {

    /**
     * Java中char在jvm中使用UTF-16编码
     * 最开始Java中char类型用16位无符号整数来描述unicode中最早一批收录的字符(BMP:Basic Multilingual Plane：基本多语言平面)，即utf-16前身USE-2，
     * 而Java中单个char类型描述的字符是有限的，只能描述unicode中BMP范围的码位，随着字符增多，BMP范围外字符char无法表示
     * utf-16使用4byte表示non-BMP中的字符，2-byte单位划分为2个16-bit的code unit(16bit)，称为代理对(surrogate pair)
     *   high surrogate：使用unicode中的保留字符位置
     *   low surrogate：
     * Java中一个char理解为一个code unit而不是一个字符
     * 而String本意为char类型的序列，可理解为code unit串更合适
     */
    private static void primitiveTypeChar() {

        // 笑脸颜文字为non-BMP，单个char无法表示
        // Too many characters in character literal
//        char charEmoji = '\uD83D\uDE42';

        // String.length()返回的是code unit的个数(不含编码标志位)，而不是字符的个数，也不是占用字节的个数
        String stringEmoji = "\uD83D\uDE42";
        System.out.println(stringEmoji + " length:" + stringEmoji.length());

        // Latin-1编码, 4个字节, 4个code unit
        // UTF-8编码, 4个字节, 4个code unit
        // Java会根据字符串内容自动设置相应编码，要么UTF-16要么LATIN1(JVM中内部编码即字符串格式为UTF-16)
        // LATIN1：对于英文字符，一个字符占用一个字节
        // UTF-16：对于BMP中/英文字符，一个汉字/字母占用2个字节
        String name = "jack";
        // utf-16编码, 4个字节, '小明'两个字符属于BPM范畴，2个code unit
        // utf-8编码, 6个字节，2个code unit
        // GKB编码, 4个字节, 2个code unit
        String name1 = "小明";
        // utf-16编码, 12个字节，6个code unit
        // utf-8编码, 10个字节，6个code unit
        String name2 = "jack小明";

        // String字符串含编码标志位coder(2byte)，用来表示使用的是utf-16编码，还是Latin-1编码
        // UTF-8(无BMP概念，非英文字符集编码字节数不定(2byte/3byte/...))无编码标志位
        // 4 4 10
        System.out.println("[jack]字符串长度：" + name.length() + ", UTF-8编码占用字节数：" + name.getBytes(StandardCharsets.UTF_8).length
                + ", UTF-16编码占用字节数：" + name.getBytes(StandardCharsets.UTF_16).length);
        // 2 6 6
        System.out.println("[小明]字符串长度：" + name1.length() + ", UTF-8编码占用字节数：" + name1.getBytes(StandardCharsets.UTF_8).length
                + ", UTF-16编码占用字节数：" + name1.getBytes(StandardCharsets.UTF_16).length);
        // 6 10 14
        System.out.println("[jack小明]字符串长度：" + name2.length() + ", UTF-8编码占用字节数：" + name2.getBytes(StandardCharsets.UTF_8).length
                + ", UTF-16编码占用字节数：" + name2.getBytes(StandardCharsets.UTF_16).length);
        // JVM的字符集编码取的是操作系统默认的字符集编码
        System.out.println("JVM默认字符集：" + Charset.defaultCharset());
    }

    public static void main(String[] args) {
        primitiveTypeChar();
    }
}
