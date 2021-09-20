package api.mapper.blogger;

import api.entity.blogger.Author;
import api.provider.blogger.AuthorProvider;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheNamespace(blocking = true)
public interface AuthorProviderMapper {

    @SelectProvider(type = AuthorProvider.class, method = "getByCondition")
    @ResultMap("author_provider_map")
    @Cacheable(value="AuthorCache",key="#id")
    List<Author> getAuthorByCondition(Author author);

}
