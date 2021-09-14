package test.java.com.moku.api.entity;

import main.java.com.moku.api.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import main.java.com.moku.api.entity.Student;

import java.io.IOException;
import java.util.List;

/**
 * 使用系统默认映射接口（不用自定义Mapper接口）
 * 映射文件的命名空间应指定为映射文件的全限定名
 *
 * @author moku
 */
public class StudentTest {

    public static void main(String[] args) throws IOException {

        // 使用系统默认映射接口（不用自定义Mapper接口）
        testWithClassLoader();

        testWithStreamObject();

        testWithReaderObject();
    }

    private static void testWithReaderObject() {

        // 创建sqlSession
        SqlSession session = MyBatisUtil.openSessionWithReader();

        // 指定映射对象方法
        Student student = session.selectOne("main.resources.mapper.Student.getStudent", 4);
        System.out.println("testWithResourcesReader: select one, ID:" + student.getId() + ",NAME:" + student.getName());

        session.close();
    }

    private static void testWithStreamObject() {

        // 创建sqlSession
        SqlSession session = MyBatisUtil.openSessionWithStream();

        // 配置类指定了映射对象，以下statement可以不用指定路径
        Student student = session.selectOne("getStudent", 3);
        System.out.println("testWithResourcesStream: select one, ID:" + student.getId() + ",NAME:" + student.getName());

        session.close();
    }

    private static void testWithClassLoader() {

        // 创建sqlSession
        SqlSession session = MyBatisUtil.openSession();

        // 增加学生
        Student student1 = new Student() {{
            this.setName("新增加的学生");
        }};
        session.insert("addStudent", student1);

        // 删除学生
        Student student2 = new Student() {{
            this.setId(1);
        }};
        // 删除：指定对象
        session.delete("deleteStudent", student2);
        // 删除：指定主键
        session.delete("deleteStudent", 8);

        // 获取学生
        Student student3 = session.selectOne("getStudent", 2);

        // 修改学生
        student3.setName("修改的学生");
        session.update("updateStudent", student3);

        // 获取学生list
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
}
