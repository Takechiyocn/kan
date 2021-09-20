package api.entity.blogger;

import lombok.Data;

import java.io.Serializable;

/**
 * tb_author：Blog作者表，与Blog一对一的关系。
 * tb_blog：Blog表，与author一对一，与post一对多。
 * tb_post：Post文章表，与blog多对一，与comment一对多，与tag一对多。
 * tb_comment：文章评论表，与post多对一。
 * tb_tag：文章标签表，与post多对一。
 */
@Data
public class Author implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String email;
    private String bio;
    private String favouriteSection;
    private static final long serialVersionUID = -2433804034194454964L;
}
