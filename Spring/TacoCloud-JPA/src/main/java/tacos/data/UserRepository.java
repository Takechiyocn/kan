package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.User;

/**
 * @description:JPA接口
 * @author: Kan
 * @date: 2021/3/10 22:42
 */
public interface UserRepository
        extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
