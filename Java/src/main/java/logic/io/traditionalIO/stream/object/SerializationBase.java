package logic.io.traditionalIO.stream.object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SerializationBase
 * @Description 序列化：Java对象存储到文件中，将Java对象保存下来的过程
 *              反序列化：将硬盘上的数据重新恢复到内存当中，恢复成Java对象
 * @Author moku
 * @Date 2022/12/1 11:38
 * @Version 1.0
 */
public class SerializationBase implements Serializable {

    // 实现Serializable接口后，会自动生成一个序列化版本号
    // 通常提供固定不变的序列化版本号
    // 该类源代码修改后再次编译，如果使用自动化序列号则虚拟机会生成新的序列化版本号
    private static final long serialVersionUID = 1L;
    private int no;
    private String name;
    // transient(游离)：不参加序列化
    private transient int age;

    public SerializationBase(int i, String s) {
        this.no = i;
        this.name = s;
    }

    public static void main(String[] args) throws IOException {

        List<SerializationBase> sa = new ArrayList<>() {{
            add(new SerializationBase(100, "A"));
            add(new SerializationBase(200, "B"));
            add(new SerializationBase(300, "C"));
        }};
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/io/traditionalIO/stream/object/file/temp.txt"));

        // 序列化对象多个对象
        oos.writeObject(sa);
        oos.flush();
        oos.close();
    }
}
