package api.service.blogger;

import api.entity.blogger.Author;
import api.mapper.blogger.AuthorMapper;
import api.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * UserService工具类
 *
 * @author moku
 */
public class AuthorService {

    SqlSession sqlSession = null;

    public List<Author> getAuthorById(int id) {

        try {
            sqlSession = MyBatisFactory.getSession();
            AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
            return mapper.getAuthor(id);
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            return null;
        } finally {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        }
    }
}
