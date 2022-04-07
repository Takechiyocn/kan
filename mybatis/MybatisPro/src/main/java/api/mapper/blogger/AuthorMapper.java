package api.mapper.blogger;

import api.entity.blogger.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorMapper {

    List<Author> getAuthor(Integer id);

    int deleteAuthorById(Integer id);

    void updateAuthorById(Author author);
}
