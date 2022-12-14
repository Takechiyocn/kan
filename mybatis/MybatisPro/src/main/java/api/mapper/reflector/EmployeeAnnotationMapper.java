package api.mapper.reflector;

import api.entity.reflector.Department;
import api.entity.reflector.Employee;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface EmployeeAnnotationMapper {

    @Select("select * from mybatis2.employee where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "dept", column = "dept_id", many = @Many(select = "selectDeptById"))
    })
    Employee selectEmployeeByPrimaryKey(Long id);

    @Select("select * from mybatis2.department where id = #{dept_id}")
    Department selectDeptById(Long id);
}
