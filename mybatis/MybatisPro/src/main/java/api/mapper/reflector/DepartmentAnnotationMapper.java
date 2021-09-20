package api.mapper.reflector;

import api.entity.reflector.Department;
import api.entity.reflector.Employee;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface DepartmentAnnotationMapper {

    @Select("select * from mybatis2.department where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "emps", column = "id", many = @Many(select = "selectEmployeeByDeptId"))
    })
    Department selectDeptById(Long id);

    @Select("select * from mybatis2.employee where dept_id = #{id}")
    Employee selectEmployeeByDeptId(Long id);
}


