package api.entity.service.blogger;

import api.entity.blogger.Author;
import api.mapper.blogger.AuthorMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 一级缓存：SqlSession会话对象级别，即在每一次会话中有效(最多存储1024条SQL)
 */
public class AuthorCacheL1Test {

    @Test
    public void testAuthorUseCacheL1() throws IOException {

        String resource = "mybatis-config.xml";
        Logger logger = LoggerFactory.getLogger(AuthorServiceTest.class);

        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        AuthorMapper mapper = session.getMapper(AuthorMapper.class);

        List<Author> authorList = mapper.getAuthor(2);
        // fastjson
        JSONArray object = JSONArray.parseArray(JSON.toJSONString(authorList));
        logger.info("author:{}", object);

        // 一级缓存
        List<Author> authorList2 = mapper.getAuthor(2);
        JSONArray object2 = JSONArray.parseArray(JSON.toJSONString(authorList2));
        logger.info("Cache L1, author:{}", object2);

        session.close();

    }

    @Test
    public void testAuthorClearCacheL1ByCloseSession() throws IOException {

        String resource = "mybatis-config.xml";
        Logger logger = LoggerFactory.getLogger(AuthorServiceTest.class);

        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        AuthorMapper mapper = session.getMapper(AuthorMapper.class);

        List<Author> authorList = mapper.getAuthor(2);
        // fastjson
        JSONArray object = JSONArray.parseArray(JSON.toJSONString(authorList));
        logger.info("author:{}", object);

        // 清空一级缓存：关闭会话
        // 由于Author映射文件设置了二级缓存，该用例测试时，需注二级缓存设置
        session.close();
        session = sqlSessionFactory.openSession();
        mapper = session.getMapper(AuthorMapper.class);
        List<Author> authorList2 = mapper.getAuthor(2);
        // fastjson
        JSONArray object2 = JSONArray.parseArray(JSON.toJSONString(authorList2));
        logger.info("New session, author:{}", object2);

        session.close();

    }

    @Test
    public void testAuthorClearCacheL1ByDMLOperation() throws IOException {

        String resource = "mybatis-config.xml";
        Logger logger = LoggerFactory.getLogger(AuthorServiceTest.class);

        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        AuthorMapper mapper = session.getMapper(AuthorMapper.class);

        List<Author> authorList = mapper.getAuthor(2);
        // fastjson
        JSONArray object = JSONArray.parseArray(JSON.toJSONString(authorList));
        logger.info("author:{}", object);

        // 清空一级缓存：DML操作/提交事务
        int delCnt = mapper.deleteAuthorById(3);
        logger.info("Delete count:{}", delCnt);
        List<Author> authorList2 = mapper.getAuthor(2);
        // fastjson
        JSONArray object2 = JSONArray.parseArray(JSON.toJSONString(authorList2));
        logger.info("New session, author:{}", object2);

        session.close();

    }

    @Test
    public void testAuthorClearCacheL1ByClearCache() throws IOException {

        String resource = "mybatis-config.xml";
        Logger logger = LoggerFactory.getLogger(AuthorServiceTest.class);

        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        AuthorMapper mapper = session.getMapper(AuthorMapper.class);

        List<Author> authorList = mapper.getAuthor(2);
        // fastjson
        JSONArray object = JSONArray.parseArray(JSON.toJSONString(authorList));
        logger.info("author:{}", object);

        // 清空一级缓存：clearCache()
        session.clearCache();
        List<Author> authorList2 = mapper.getAuthor(2);
        JSONArray object2 = JSONArray.parseArray(JSON.toJSONString(authorList2));
        logger.info("After clearCache, author:{}", object2);

        session.close();

    }
}
