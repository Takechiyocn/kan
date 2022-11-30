package io.stream.data;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName DataOutputStreamBase
 * @Description 将数据和数据类型写入文件(不是普通文本文档)
 * @Author moku
 * @Date 2022/12/1 0:51
 * @Version 1.0
 */
public class DataOutputStreamBase {
    public static void main(String[] args) throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/main/java/io/stream/data/file/dosdata"));

        byte b = 100;
        short s =200;
        int i =300;
        long l = 400L;
        float f =3.0f;
        double d = 3.14;
        boolean sex = false;
        char c = 'a';

        dos.writeByte(b);
        dos.writeShort(s);
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.writeBoolean(sex);
        dos.writeChar(c);

        dos.flush();
        dos.close();
    }
}
