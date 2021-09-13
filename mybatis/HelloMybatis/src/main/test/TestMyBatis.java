package main.test;

import main.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

//    private static SqlSessionFactory sqlSessionFactory;
//    private static Reader reader;
//    static {
//        try {
//            // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
//            String resource = "mybatis-config.xml";
////            InputStream inputStream = Resources.getResourceAsStream(resource);
//            reader = Resources.getResourceAsReader(resource);
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static SqlSessionFactory getSession() {
//        return sqlSessionFactory;
//    }


    public static void main(String[] args) throws IOException {

        sessionWithInputStream();

    }

    private static void sessionWithInputStream() throws IOException {
        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();
        List<Student> listStudent = session.selectList("listStudent");

        for (Student student : listStudent) {
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }
    }

//        main.pojo.StudentDao mapper = session.getMapper(main.pojo.StudentDao.class);
//
//        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
//        List<main.pojo.Student> listStudent = mapper.selectList("listStudent");

//
//        main.pojo.Student student = mapper.selectByPrimaryKey(1);
//        if (student != null) {
//            System.out.println(student.toString());
//        } else {
//            System.out.println("empty object");
//        }
//    }
}