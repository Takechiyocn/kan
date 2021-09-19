package com.moku.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Factory {

    private final static Class<Factory> lock = Factory.class;
    private static SqlSessionFactory sqlSessionFactory = null;
    private Factory() {}

    /**
     * 对外提供一个工厂
     *
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {

        synchronized (lock) {
            if (sqlSessionFactory != null) {
                return sqlSessionFactory;
            }

            // 加载核心配置文件
            String resources = "mybatis-config.xml";
            InputStream inputStream;
            try {
                // 1.传入mybatis配置文件获取其文件流
                inputStream = Resources.getResourceAsStream(resources);
                // 2.通过文件流创建SqlSessionFactory工厂
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            // 对外提供一个工厂
            return sqlSessionFactory;
        }
    }

    /**
     * 对外提供一个SqlSession会话
     *
     * @return SqlSession
     */
    public static SqlSession getSession() {

        if (sqlSessionFactory == null) {
            getSqlSessionFactory();
        }

        // 3.通过工厂获取会话
        return sqlSessionFactory.openSession();
    }
}
