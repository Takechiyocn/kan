package api.provider.blogger;

import api.entity.blogger.Author;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class AuthorProvider {

    public String getByCondition(Author author) {
        return new SQL() {{
            SELECT("*");
            FROM("tb_author");
            if (null != author.getId()) {
                WHERE("author_id = ${id}");
            }
            if (StringUtils.isNotBlank(author.getUserName())) {
                WHERE("author_username like concat('%', #{userName}, '%')");
            }
        }}.toString();
    }
}
