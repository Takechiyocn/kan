package main.java.com.moku.api.mapper;

import main.java.com.moku.api.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 使用MyBatis的动态代理开发编写代码遵循四个原则
 * 1.映射文件的namespace命名空间的值必须是对应接口的全限定名。
 * 2.映射文件的对应功能 id值必须等于映射接口中方法的名称。
 * 3.映射文件的参数类型必须和接口中方法的参数类型一致。
 * 4.映射文件查询的返回结果类型必须和接口的方法的返回数据类型一致，DML操作返回的受影响的行数，除外。
 *
 * @author moku
 */
public interface UserMapper {

    void insert(User user);

    User selectUserById(long id);

    List<User> selectAll();

    void deleteUserById(long id);

    void updateUserById(User user);

    // OGNL
    int dropTable(@Param("tableName") String tblName);

    /**
     * 标签复用：根据条件查询结果
     */
    List<User> selectByCondition(User user);

    /**
     * 标签复用：根据条件查询结果总数
     */
    Long selectTotalByCondition(User user);

    /**
     * 标签复用：修改用户
     */
    int updateUserByNotNull(User user);

    /**
     * 标签复用：批量删除
     */
    int deleteByIds(@Param("ids") Integer[] ids);

    /**
     * 标签复用：批量插入
     */
    int insertByBatch(@Param("users")List<User> users);

}
