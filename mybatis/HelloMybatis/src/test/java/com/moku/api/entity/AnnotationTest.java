package test.java.com.moku.api.entity;

import main.java.com.moku.api.entity.Employee;
import main.java.com.moku.api.entity.User;
import main.java.com.moku.api.mapper.AnnotationMapper;
import main.java.com.moku.api.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 注解
 *
 * @author moku
 */
public class AnnotationTest {

    @Test
    public void testAnnotation() {

        Logger logger = LoggerFactory.getLogger(AnnotationTest.class);
        SqlSession session = MyBatisUtil.openSession();
        SqlSession userSession = MyBatisUtil.openSession();

        try {
            AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);

            // 单条记录查找：手动映射结果集和对象属性
            Employee employee = mapper.queryOneAnnotation(43L);
            if (null != employee) {
                logger.info("Name:" + employee.getName() + ", id:" + employee.getId());
            }

            // 插入记录
            User newUser = new User() {{
                this.setName("new user");
                this.setAge(16);
                this.setEmail("test@gmail.com");
                this.setPassword("test");
            }};
            mapper.insertAnnotation(newUser);

            // 查找所有记录
            List<User> users = mapper.queryAllAnnotation();
            for (User user : users) {
                logger.info(user.getName());
            }

            // 删除记录
            mapper.deleteUserByIdAnnotation(47L);

            // 更新记录
            User updUser = new User() {{
                this.setId(20L);
                this.setName("upd user");
                this.setAge(20);
                this.setEmail("updtest@gmail.com");
                this.setPassword("upd test");
            }};
            mapper.updateUserByIdAnnotation(updUser);

            // 方法多参数传递1：将参数封装到对象里(JavaBean)
            User loginUser = mapper.login(newUser);
            logger.info("loginUser: " + loginUser.getName() + ", " + loginUser.getPassword());

            // 方法多参数传递1：将参数封装到对象里(Map)
            Map<String, Object> userMap = new HashMap<>() {{
                put("name", "upd user");
                put("password", "upd test");
            }};
            User loginUser2 = mapper.login2(userMap);
            logger.info("loginUser: " + loginUser2.getName() + ", " + loginUser2.getPassword());

            // 方法多参数传递2：使用Param注解
            User loginUser3 = mapper.login3("moku", "test");
            logger.info("loginUser: " + loginUser3.getName() + ", " + loginUser3.getPassword());

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}

