package api.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 获取sql session
 *
 * @author moku
 */
public class MyBatisFactory {

    private static final String RESOURCE = "mybatis-config.xml";
    private static final Class<MyBatisFactory> LOCK = MyBatisFactory.class;
    private static SqlSessionFactory sqlSessionFactory;

    private MyBatisFactory() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {

        synchronized (LOCK) {
            if (sqlSessionFactory != null) {
                return sqlSessionFactory;
            }

            // 加载核心配置文件
            // 获取mybatis配置文件流（带资源的try语句，异常发生时自动调用close方法关闭资源）
//            try (InputStream in = Resources.getResourceAsStream(RESOURCE)){
//            try (Reader in = Resources.getResourceAsReader(RESOURCE)){
            try (InputStream in = MyBatisFactory.class.getClassLoader().getResourceAsStream(RESOURCE)){
                // 创建SqlSessionFactory工厂
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            // 返回工厂
            return sqlSessionFactory;
        }
    }

    public static SqlSession getSession() {
        if (sqlSessionFactory == null) {
            getSqlSessionFactory();
        }

        // 获取会话
        return sqlSessionFactory.openSession();
    }
}
