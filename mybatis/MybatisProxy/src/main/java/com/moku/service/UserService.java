package com.moku.service;

import com.moku.bean.User;
import com.moku.mapper.UserMapper;
import com.moku.utils.Factory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 实现类（原始dao开发中的impl类）
 *
 * @author moku
 */
public class UserService {

    SqlSession sqlSession = null;

    // 增
    public boolean addUser(User user) {

        try {
            // 1.通过工厂获取会话
            sqlSession = Factory.getSession();
            // 2.从会话中获取接口的代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 3.通过代理对象操作数据库
            userMapper.addUser(user);
            // 4.提交事务
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

    // 删
    public boolean deleteUserById(int id) {

        try {
            sqlSession = Factory.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            boolean tf = userMapper.deleteUserById(id);
            sqlSession.commit();
            return tf;
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            return false;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    // 改
    public boolean updateUserById(User user) {

        try {
            sqlSession = Factory.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUserById(user);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            return false;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    // 查：按id查一个
    public User getUserById(int id) {

        try {
            sqlSession = Factory.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserById(id);
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    // 查：查所有
    public List<User> getUser() {

        try {
            sqlSession = Factory.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUser();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
