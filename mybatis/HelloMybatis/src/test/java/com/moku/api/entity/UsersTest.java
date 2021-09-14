package test.java.com.moku.api.entity;

import main.java.com.moku.api.entity.User;
import main.java.com.moku.api.mapper.UserMapper;
import main.java.com.moku.api.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UsersTest {

    @Test
    public void testInsert() {
        final Logger logger = LogManager.getLogger(UsersTest.class);
        final org.slf4j.Logger logger2 = org.slf4j.LoggerFactory.getLogger(UsersTest.class);
        logger.info("***********logger info***********");
        logger2.info("***********logger info2***********");

        SqlSession session = MyBatisUtil.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = new User() {{
                this.setName("李四");
                this.setAge(14);
                this.setEmail("lisi@qq.com");
                this.setPassword("lisi");
            }};

            // 插入
            userMapper.insert(user);

            // 单条记录查找
            User user2 = userMapper.selectUserById(1);
            logger.info(user2.getName());

            // 多条记录查找
            List<User> userList = userMapper.selectAll();
            for (User user3 : userList) {
                logger.info("Name:" + user3.getName() + ", id:" + user3.getId());
            }

            // 删除记录
            userMapper.deleteUserById(20L);

            // 更新记录
            User user4 = new User() {{
                this.setId(16L);
                this.setName("zhangsan");
                this.setAge(15);
                this.setEmail("zhangsan@126.com");
                this.setPassword("zhangsan123123123");
            }};
            userMapper.updateUserById(user4);

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}

