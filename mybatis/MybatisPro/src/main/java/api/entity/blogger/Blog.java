package api.entity.blogger;

import lombok.Data;

import java.util.List;

@Data
public class Blog {
    private Integer id;
    private String title;
    private Author author;
    private List<Post> posts;

    /**
     * MyBatis构造器结果映射
     * @param id
     */
    public Blog(Integer id) {
        this.id = id;
    }
}
