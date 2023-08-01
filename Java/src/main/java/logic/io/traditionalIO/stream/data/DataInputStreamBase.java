package logic.io.traditionalIO.stream.data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName DataInputStreamBase
 * @Description 数据字节写入流：DataOutputStream写的文件必须用该类去读，且读写顺序一致
 * @Author moku
 * @Date 2022/12/1 0:59
 * @Version 1.0
 */
public class DataInputStreamBase {
    public static void main(String[] args) throws IOException {

        DataInputStream dis = new DataInputStream(new FileInputStream("src/main/java/io/stream/data/file/dosdata"));

        Byte b = dis.readByte();
        Short s = dis.readShort();
        int i = dis.readInt();
        Long l = dis.readLong();
        Float f = dis.readFloat();
        Double d = dis.readDouble();
        Boolean sex = dis.readBoolean();
        char c = dis.readChar();

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(sex);
        System.out.println(c);
    }
}
