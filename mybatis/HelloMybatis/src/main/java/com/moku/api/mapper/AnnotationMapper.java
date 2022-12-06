package main.java.com.moku.api.mapper;

import main.java.com.moku.api.entity.Employee;
import main.java.com.moku.api.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface AnnotationMapper {

    @Select("select e_id, e_name, e_age, e_email from employee where e_id = #{id}")
    @Results({
            @Result(id = true, column = "e_id", jdbcType = JdbcType.BIGINT, property = "id"),
            @Result(column = "e_name", jdbcType = JdbcType.VARCHAR, property = "name"),
            @Result(column = "e_age", jdbcType = JdbcType.INTEGER, property = "age"),
            @Result(column = "e_email", jdbcType = JdbcType.VARCHAR, property = "email")
    })
    Employee queryOneAnnotation(long id);

    @Insert("insert into muser (name, age, email, password) values (#{name}, #{age}, #{email}, #{password})")
    void insertAnnotation(User user);

    @Select("select * from muser")
    List<User> queryAllAnnotation();

    @Delete("delete from muser where id = #{id}")
    void deleteUserByIdAnnotation(long id);

    @Update("        update\n" +
            "            muser\n" +
            "        set\n" +
            "            name = #{name},\n" +
            "            age = #{age},\n" +
            "            email = #{email},\n" +
            "            password = #{password}\n" +
            "        where\n" +
            "            id = #{id}")
    void updateUserByIdAnnotation(User user);

    // 方法多参数传递1：将参数封装到对象里(JavaBean)
    @Select("select * from muser where id <= 50 and name = #{name} and password = #{password}")
    User login(User user);

    // 方法多参数传递1：将参数封装到对象里(Map)
    @Select("select * from muser where name = #{name} and password = #{password}")
    User login2(Map<String, Object> map);

    // 方法多参数传递2：使用Param注解
    @Select("select * from muser where name = #{name} and password = #{password}")
    User login3(@Param("name") String nm, @Param("password") String pwd);

}
