package api.service.blogger;

import api.entity.blogger.Blog;
import api.mapper.blogger.BlogMapper;
import api.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BlogService {

    private SqlSession sqlSession = null;

    public List<Blog> getBlog(int id) {

        try {
            sqlSession = MyBatisFactory.getSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            return mapper.getBlog(id);
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            return null;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
