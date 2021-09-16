package api.entity.blogger;

import api.mapper.blogger.AuthorMapper;
import api.utils.MyBatisUtil;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;

import java.util.List;

public class AuthorMapperTest {

    @Test
    public void testAuthorMapper() {

        SqlSession session = MyBatisUtil.openSessionWithStream();
        AuthorMapper mapper = session.getMapper(AuthorMapper.class);
        Logger logger = LoggerFactory.getLogger(AuthorMapperTest.class);

        List<Author> authorList = mapper.getAuthor(2);
        JSONArray object = JSONArray.parseArray(JSON.toJSONString(authorList));
        logger.info("author:{}", object);

        session.close();
    }
}