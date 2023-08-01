package logic.serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.google.gson.Gson;

import java.io.*;

/**
 * @ClassName Transient
 * @Description 序列化
 *                1. Java原生序列化，实现Serializable接口：Java序列化保留对象类的元数据(类、成员变量、继承类信息)
 *                2. Hessian序列化：支持动态类型、跨语言、基于对象传输的网络协议
 *                   被序列化的类需要实现Serializable接口
 *                3.Json序列化：将数据对象转换为JSON字符串，序列化过程中抛弃了类型信息，所以反序列化时候只有提供类型信息才能准确进行
 * @Author moku
 * @Date 2022/12/11 0:48
 * @Version 1.0
 */
public class Transient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1. Java原生序列化：实现Serializable接口
        serializableOfJava();

        // 2. Hessian序列化()
        //    序列化原理：利用反射
        //    反序列化原理：找到一个性能最高的constructor，
        //                入参基本类型传0、false等，引用类型传null(所以如果constructor中判断参数不能为null，则会报错)
        //                constructor可为private
        hessianSerializable();

        // 3. Json序列化
        jsonSerializable();

    }

    private static void serializableOfJava() throws IOException, ClassNotFoundException {
        // 静态变量和瞬态变量
        Person p = new Person();

        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/serializable/file/fos.txt"));
        oos.writeObject(p);
        oos.close();

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/serializable/file/fos.txt"));
        System.out.println("1.Java原生序列化：" + ois.readObject());
        ois.close();
    }

    private static void jsonSerializable() {
        Person3 p = new Person3("序列化", "男", 25);

        // 实例化Gson
        Gson gson = new Gson();

        // 序列化
        String s = gson.toJson(p);
        System.out.println("3.Json序列化" + s);

        // 反序列化
        Gson gson2 = new Gson();
        Person3 p2 = gson.fromJson(s, Person3.class);
        System.out.println("3.Json反序列化" + p2);
    }

    private static void hessianSerializable() throws IOException {
        Person2 p = new Person2();
        p.setAddress("屋子科");
        p.setName("ymz");

        // 序列化
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(os);
        output.writeObject(p);
        output.close();

        // 反序列化
        ByteArrayInputStream in = new ByteArrayInputStream(os.toByteArray());
        Hessian2Input input = new Hessian2Input(in);
        System.out.println("2.反序列化：" + input.readObject().toString());
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

class Person2 implements Serializable {
    private String name;
    public static String hobby = "eat";
    transient private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getHobby() {
        return hobby;
    }

    public static void setHobby(String hobby) {
        Person2.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person[name:" + name + ",hobby:" + hobby + ",address:" + address + "]";
    }
}

class Person3 {
    /* 姓名*/
    private String name;
    /* 性别*/
    private String sex;
    /* 年龄*/
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public Person3(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
