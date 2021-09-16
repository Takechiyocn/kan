package api.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * 获取sql session
 *
 * @author moku
 */
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSessionFactory sqlSessionFactory2;
    private static SqlSessionFactory sqlSessionFactory3;
    private static final String RESOURCE = "mybatis-config.xml";

    private MyBatisUtil() {
    }

    // 构建sqlSession工厂方法1：ClassLoader
//    static {
//        try (InputStream in = MyBatisUtil.class.getClassLoader().getResourceAsStream(RESOURCE)) {
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    // 构建sqlSession工厂方法2：Stream Object
    static {
        try (InputStream in2 = Resources.getResourceAsStream(RESOURCE)) {
            sqlSessionFactory2 = new SqlSessionFactoryBuilder().build(in2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 构建sqlSession工厂方法3：Reader Object
    static {
        try (Reader reader = Resources.getResourceAsReader(RESOURCE)) {
            sqlSessionFactory3 = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建能执行映射文件中sql的sqlSession：ClassLoader
     *
     * @return sqlSession
     */
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    /**
     * 创建能执行映射文件中sql的sqlSession：Stream Object
     *
     * @return sqlSession
     */
    public static SqlSession openSessionWithStream() {
        // 创建能执行映射文件中sql的sqlSession
        return sqlSessionFactory2.openSession();
    }

    /**
     * 创建能执行映射文件中sql的sqlSession：Reader Object
     *
     * @return sqlSession
     */
    public static SqlSession openSessionWithReader() {
        // 创建能执行映射文件中sql的sqlSession
        return sqlSessionFactory3.openSession();
    }
}
