package logic.io.traditionalIO.stream.object;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName DeSerializationBase
 * @Description  反序列化：将硬盘上的数据重新恢复到内存当中，恢复成Java对象
 * @Author moku
 * @Date 2022/12/1 13:12
 * @Version 1.0
 */
public class DeSerializationBase {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("src/main/java/io/stream/object/file/user.properties");
        // 创建一个Map集合：Hashtable子类Properties
        Properties p = new Properties();
        // 将文件数据加载到Map集合中
        p.load(fr);
        System.out.println(p.getProperty("username"));
        System.out.println(p.getProperty("password"));
    }
}
