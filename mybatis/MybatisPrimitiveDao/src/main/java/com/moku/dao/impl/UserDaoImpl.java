package com.moku.dao.impl;

import com.moku.bean.User;
import com.moku.dao.UserDao;
import com.moku.utils.Factory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 原始dao需要实现接口
 *
 * @author moku
 */
public class UserDaoImpl implements UserDao {

    SqlSession sqlSession = null;

    // 增
    @Override
    public boolean addUser(User user) {

        try {
            // 1.通过工厂获取会话
            sqlSession = Factory.getSession();
            // 2.通过代会话操作数据库
            sqlSession.insert("addUser", user);
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

    // 删
    @Override
    public boolean deleteUserById(int id) {

        try {
            sqlSession = Factory.getSession();
            sqlSession.delete("deleteUserById", id);
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

    // 改
    @Override
    public boolean updateUserById(User user) {

        try {
            sqlSession = Factory.getSession();
            sqlSession.update("getMapper", user);
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
    @Override
    public User getUserById(int id) {

        try {
            sqlSession = Factory.getSession();
            return sqlSession.selectOne("getUserById", id);
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
    @Override
    public List<User> getUser() {

        try {
            sqlSession = Factory.getSession();
            return sqlSession.selectList("getUser");
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
