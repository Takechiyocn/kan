package api.entity.blogger;

import api.service.blogger.AuthorService;
import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;

import java.util.List;

public class AuthorServiceTest {

    @Test
    public void testAuthorMapper() {

        Logger logger = LoggerFactory.getLogger(AuthorServiceTest.class);
        AuthorService service = new AuthorService();

        List<Author> authorList = service.getAuthorById(2);
        JSONArray object = JSONArray.parseArray(JSON.toJSONString(authorList));
        logger.info("author:{}", object);
    }
}