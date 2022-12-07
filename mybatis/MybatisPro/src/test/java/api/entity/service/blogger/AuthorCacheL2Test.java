package api.entity.service.blogger;

import api.entity.blogger.Author;
import api.entity.blogger.Blog;
import api.mapper.blogger.AuthorMapper;
import api.mapper.blogger.BlogMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * 二级缓存：SqlSessionFactory工厂级别，即在整个应用都有效，可在多个会话中有效
 * 优缺点：
 *   1. 缓存以namespace为单位，不同namespace操作互不影响
 *   2. DML(insert添加，delete删除，update修改)操作会清空namespace下全部缓存
 *   3. Mybatis Generator生成的代码，各个表都是独立的，每个表都有自己的namespace
 *   4. 多表操作不推荐使用二级缓存，因为多表操作更新时会产生脏数据
 *      --> 二级缓存为表级缓存，开销大，可用一级缓存(使用HashMap存储)替换，效率更高
 */
public class AuthorCacheL2Test {

    @Test
    public void testAuthorCacheL2() throws IOException {

        String resource = "mybatis-config.xml";
        Logger logger = LoggerFactory.getLogger(AuthorServiceTest.class);

        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        for (int i = 0; i < 10; i++) {
            SqlSession session = sqlSessionFactory.openSession();
            AuthorMapper mapper = session.getMapper(AuthorMapper.class);

            List<Author> authorList = mapper.getAuthor(2);
            // fastjson
            JSONArray object = JSONArray.parseArray(JSON.toJSONString(authorList));
            logger.info("author:{}", object);

            session.close();
        }
    }

    /**
     * 二级缓存失效
     *   1. session未提交
     *   2. 更新对二级缓存的影响
     *
     * @throws IOException
     */
    @Test
    public void testAuthorCacheL2Invalid() throws IOException {
        String resources = "mybatis-config.xml";
        Logger logger = LoggerFactory.getLogger(AuthorCacheL2Test.class);

        Reader reader = Resources.getResourceAsReader(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // 二级缓存失效：1. session未提交(commit/close)
        for (int i = 0; i < 3; i++) {
            SqlSession session = sqlSessionFactory.openSession();
            AuthorMapper mapper = session.getMapper(AuthorMapper.class);

            List<Author> authorList = mapper.getAuthor(2);

            JSONArray object = JSONArray.parseArray(JSON.toJSONString(authorList));
            logger.info("author:{}", object);

            // 二级缓存失效：1. session未提交(commit/close)
//            session.commit();
//            session.close();
        }

        // 二级缓存失效：2. 更新对二级缓存的影响
        SqlSession[] session = new SqlSession[4];
        AuthorMapper[] mapper = new AuthorMapper[4];
        for (int i = 0; i < 4; i++) {
            session[i] = sqlSessionFactory.openSession();
            mapper[i] = session[i].getMapper(AuthorMapper.class);
        }

        // 1. 执行更新操作(包含get DB)并提交事务
        List<Author> authorList1 = mapper[0].getAuthor(2);
        session[0].commit();
        JSONArray object1 = JSONArray.parseArray(JSON.toJSONString(authorList1));
        logger.info("author:{}", object1);

        // 2. 从二级缓存中读取
        List<Author> authorList2 = mapper[0].getAuthor(2);
        JSONArray object2 = JSONArray.parseArray(JSON.toJSONString(authorList2));
        logger.info("author:{}", object2);

        // 3. 执行更新操作并提交事务
        Author author = authorList2.get(0);
        author.setBio(author.getBio()+"added");
        mapper[2].updateAuthorById(author);
        session[2].commit();

        // 2. 二级缓存失效：从DB中读取
        List<Author> authorList4 = mapper[3].getAuthor(2);
        JSONArray object4 = JSONArray.parseArray(JSON.toJSONString(authorList4));
        logger.info("author:{}", object4);
    }

    /**
     * 二级缓存多表操作产生脏数据
     *
     * @throws IOException
     */
    @Test
    public void testAuthorCacheL2DirtyData() throws IOException {
        String resource = "mybatis-config.xml";
        Logger logger = LoggerFactory.getLogger(AuthorServiceTest.class);

        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 1. 多表查询
        SqlSession session1 = sqlSessionFactory.openSession();
        BlogMapper mapper1 = session1.getMapper(BlogMapper.class);
        List<Blog> blogList = mapper1.getBlog(1);
        // Gson:对象序列化
        Gson gson = new Gson();
        String jsonResult = gson.toJson(blogList, new TypeToken<List<Blog>>() {}.getType());
        logger.info("author:{}", jsonResult);
        session1.close();

        // 2. 表更新并提交
        SqlSession session2 = sqlSessionFactory.openSession();
        BlogMapper mapper2 = session2.getMapper(BlogMapper.class);
        Blog blog = blogList.get(0);
        // String转int
//        Integer.valueOf("7");
        blog.setTitle(
                blog.getTitle().length() > 11 ? blog.getTitle().substring(0,11) + (Integer.parseInt(blog.getTitle().substring(11)) + 1) : blog.getTitle()+ 1);
        mapper2.updateBlog(blog);
        session2.commit();

        // 3. 多表查询 --> 结果为上述1操作产生的二级缓存
        SqlSession session3 = sqlSessionFactory.openSession();
        BlogMapper mapper3 = session3.getMapper(BlogMapper.class);
        List<Blog> blogList2 = mapper3.getBlog(1);
        // Gson:对象序列化
        String jsonResult2 = gson.toJson(blogList2, new TypeToken<List<Blog>>() {}.getType());
        logger.info("author:{}", jsonResult2);
    }
}
