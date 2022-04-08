package com.thymeleaf.thymeleafdemo.mapper;

import com.thymeleaf.thymeleafdemo.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> findAll();

    @Insert("insert into student ( name ) values (#{name}) ")
    int save(Student student);

    @Delete("delete from student where id= #{id} ")
    void delete(int id);

    @Select("select * from student where id= #{id} ")
    Student get(int id);

    @Update("update student set name=#{name} where id=#{id} ")
    int update(Student student);
}