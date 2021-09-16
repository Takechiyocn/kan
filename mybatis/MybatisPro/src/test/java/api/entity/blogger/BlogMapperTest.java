package api.entity.blogger;

import api.mapper.blogger.BlogMapper;
import api.utils.MyBatisUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BlogMapperTest {

    @Test
    public void testBlogMapper() {

        SqlSession session = MyBatisUtil.openSessionWithStream();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Logger logger = LoggerFactory.getLogger(BlogMapperTest.class);

        // TODO:List反序列化, Tools集计
        List<Blog> blogList = mapper.getBlog(1);
        // 对象序列化
        Gson gson = new Gson();
        String jsonResult = gson.toJson(blogList, new TypeToken<List<Author>>() {}.getType());
        logger.info("author:{}", jsonResult);

        // 对象list序列化
        Blog blog = blogList.get(0);
        String blogJson = gson.toJson(blog);
        logger.info("author2:{}", jsonResult);
    }
}
