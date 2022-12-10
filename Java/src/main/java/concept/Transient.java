package concept;

import java.io.*;

/**
 * @ClassName Transient
 * @Description
 * @Author moku
 * @Date 2022/12/11 0:48
 * @Version 1.0
 */
public class Transient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 静态变量和瞬态变量
        Person p = new Person();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/concept/file/fos.txt"));
        oos.writeObject(p);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/concept/file/fos.txt"));
        System.out.println(ois.readObject());
        ois.close();
    }
}

class Person implements Serializable {
    static String name = "user";
    static int birthday = 1989;
    // 瞬态变量不能被序列化(只有对象才能被序列化)，故序列化时toString后age=0
    transient int age = 18;

    @Override
    public String toString() {
        return "Person[name:" + name + ",birthday:" + birthday + ",age:" + age + "]";
    }
}
