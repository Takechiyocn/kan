package test.java.com.moku.api.entity;

import main.java.com.moku.api.entity.User;
import main.java.com.moku.api.mapper.UserMapper;
import main.java.com.moku.api.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class UsersTest {

    @Test
    public void testInsert() {
        final Logger logger = LogManager.getLogger(UsersTest.class);
        logger.info("***********logger info***********");

        final org.slf4j.Logger logger2 = org.slf4j.LoggerFactory.getLogger(UsersTest.class);
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
            userMapper.insert(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}

