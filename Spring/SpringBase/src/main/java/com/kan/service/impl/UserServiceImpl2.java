package com.kan.service.impl;

import com.kan.entity.User;
import com.kan.service.UserService;
import com.kan.utils.Factory;
import org.apache.ibatis.session.SqlSession;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author moku
 * @Date 2022/12/8 15:38
 * @Version 1.0
 */
public class UserServiceImpl2 implements UserService {
    SqlSession sqlSession = null;

    // 增
    @Override
    public boolean addUser(User user) {

        try {
            // 1.通过工厂获取会话
            sqlSession = Factory.getSession();
            // 2.通过会话操作数据库
            sqlSession.insert("addUser2", user);
            // 3.提交事务：增删改都需要提交事务
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            // 回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            return false;
        } finally {
            // 关闭连接，释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
