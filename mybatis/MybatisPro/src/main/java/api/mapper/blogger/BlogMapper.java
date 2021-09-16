package api.mapper.blogger;

import api.entity.blogger.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {

    List<Blog> getBlog(Integer id);
}
