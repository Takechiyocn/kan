package test.java.com.moku.api.entity;

import main.java.com.moku.api.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import main.java.com.moku.api.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class TestMyBatis {

    public static void main(String[] args) throws IOException {
        // 配置文件
        String resource = "mybatis-config.xml";

        testWithClassLoader(resource);
        testWithResourcesStream(resource);
        testWithResourcesReader(resource);
        testUseUtils(resource);
    }

    private static void testUseUtils(String resource) {
        SqlSession session = MyBatisUtil.openSession();
        Student student = session.selectOne("getStudent", 3);
        System.out.println("testUseUtils: select one, ID:" + student.getId() + ",NAME:" + student.getName());

        session.close();
    }

    private static void testWithResourcesReader(String resource) throws IOException {
        SqlSession session = getSessionWithResourcesReader(resource);
        // 指定映射对象方法
        Student student = session.selectOne("main.resources.mapper.Student.getStudent", 3);
        System.out.println("testWithResourcesReader: select one, ID:" + student.getId() + ",NAME:" + student.getName());

        session.close();
    }

    private static void testWithResourcesStream(String resource) throws IOException {
        SqlSession session = getSessionWithResourcesStream(resource);
        // 配置类指定了映射对象，以下statement可以不用指定路径
        Student student = session.selectOne("getStudent", 3);
        System.out.println("testWithResourcesStream: select one, ID:" + student.getId() + ",NAME:" + student.getName());

        session.close();
    }

    private static void testWithClassLoader(String resource) {

        SqlSession session = getSessionWithClassLoader(resource);

        // 增加学生
        Student student1 = new Student() {{
            this.setId(4);
            this.setStudentID(4);
            this.setName("新增加的学生");
        }};
//        session.insert("addStudent", student1);

        // 删除学生
        Student student2 = new Student() {{
            this.setId(1);
        }};
        session.delete("deleteStudent", student2);

        // 获取学生
        Student student3 = session.selectOne("getStudent", 2);

        // 修改学生
        student3.setName("修改的学生");
        session.update("updateStudent", student3);

        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
        List<Student> listStudent = session.selectList("listStudent");
        for (Student student : listStudent) {
            System.out.println("testWithClassLoader: select list, ID:" + student.getId() + ",NAME:" + student.getName());
        }

        // 模糊查询
        List<Student> students = session.selectList("findStudentByName", "三颗心脏");
        for (Student student : students) {
            System.out.println("testWithClassLoader: select one, ID:" + student.getId() + ",NAME:" + student.getName());
        }

        session.commit();
        session.close();
    }

    public static SqlSession getSessionWithClassLoader(String resource) {
        // 加载配置文件
        InputStream is = TestMyBatis.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 创建能执行映射文件中sql的sqlSession
        SqlSession session = sqlSessionFactory.openSession();

        return session;
    }

    public static SqlSession getSessionWithResourcesStream(String resource) throws IOException {
        // 加载配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 创建能执行映射文件中sql的sqlSession
        SqlSession session = sqlSessionFactory.openSession();

        return session;
    }

    public static SqlSession getSessionWithResourcesReader(String source) throws IOException {
        // 加载配置文件
        Reader reader = Resources.getResourceAsReader(source);
        // 构建sqlSession的工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 创建能执行映射文件中sql的sqlSession
        SqlSession session = sqlSessionFactory.openSession();

        return session;
    }
}