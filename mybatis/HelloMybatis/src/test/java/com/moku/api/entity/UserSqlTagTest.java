package test.java.com.moku.api.entity;

import main.java.com.moku.api.entity.User;
import main.java.com.moku.api.mapper.UserMapper;
import main.java.com.moku.api.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * SQL标签
 *
 * @author moku
 */
public class UserSqlTagTest {

    /**
     * 非Maven使用LoggerFactory构建logger
     */
    public static Logger logger = LoggerFactory.getLogger(UserSqlTagTest.class);
    public static SqlSession session = MyBatisUtil.openSessionWithReader();
    public static UserMapper mapper = session.getMapper(UserMapper.class);

    @Test
    public void testSelectByCondition() {

        // 根据条件查询结果
        User user = new User() {{
            this.setName("zhangsan");
            this.setAge(15);
        }};
        List<User> userList = mapper.selectByCondition(user);
        for (User usr : userList) {
            logger.info("Name:{}, Age:{}, Email:{}", usr.getName(), usr.getAge(), user.getEmail());
        }
    }

    @Test
    public void testSelectTotalByCondition() {

        // 根据条件查询结果总数
        User user = new User() {{
            this.setName("zhangsan");
            this.setAge(15);
        }};
        long userCount = mapper.selectTotalByCondition(user);
        logger.info("Query Count {}", userCount);
    }

    @Test
    public void testUpdateUserByNotNull() {

        // 修改用户
        User user2 = new User() {{
            this.setId(19L);
            this.setName("updated");
            this.setAge(18);
        }};
        int updCnt = mapper.updateUserByNotNull(user2);
        logger.info("Updated Count {}", updCnt);
    }

    @Test
    public void testDeleteByIds() {

        // 批量删除
        int delCnt = mapper.deleteByIds(new Integer[]{21, 22, 23});
        logger.info("Deleted Count {}", delCnt);
    }

    @Test
    public void testInsertByBatch() {
        // 批量插入
        List<User> userList2 = new ArrayList<>() {{
            add(new User() {{
                this.setName("batchUser");
                this.setAge(20);
                this.setEmail("email1");
                this.setPassword("pwd1");
            }});
            add(new User() {{
                this.setName("batchUser2");
                this.setAge(21);
                this.setEmail("email2");
                this.setPassword("pwd2");
            }});
            add(new User() {{
                this.setName("batchUser3");
                this.setAge(22);
                this.setEmail("email3");
                this.setPassword("pwd3");
            }});
        }};
        int insCnt = mapper.insertByBatch(userList2);
        logger.info("BatchInsert Count {}", insCnt);

        session.commit();
    }
}
