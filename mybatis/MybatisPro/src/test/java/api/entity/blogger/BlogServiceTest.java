package api.entity.blogger;

import api.service.blogger.BlogService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BlogServiceTest {

    @Test
    public void testBlogMapper() {

        BlogService service = new BlogService();
        Logger logger = LoggerFactory.getLogger(BlogServiceTest.class);

        // TODO:List反序列化, Tools集计
        List<Blog> blogList = service.getBlog(1);
        // Gson:对象序列化
        Gson gson = new Gson();
        String jsonResult = gson.toJson(blogList, new TypeToken<List<Author>>() {}.getType());
        logger.info("author:{}", jsonResult);

        // Gson:对象list序列化
        Blog blog = blogList.get(0);
        String blogJson = gson.toJson(blog);
        logger.info("author2:{}", jsonResult);
    }
}
