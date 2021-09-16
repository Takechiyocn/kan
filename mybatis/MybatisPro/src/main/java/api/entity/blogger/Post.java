package api.entity.blogger;

import lombok.Data;

import java.util.List;

@Data
public class Post {
    private Integer id;
    private String subject;
    private Author author;
    private List<Comment> comments;
    private List<Tag> tags;
    private Integer draftStatus;
    private String content;
}
