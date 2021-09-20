package api.mapper.reflector;

import api.entity.reflector.Department;
import api.entity.reflector.Employee;

public interface EmployeeMapper {

    Employee selectEmployeeByPrimaryKey(Long id);

    Employee selectEmployeeByPrimaryKey2(Long id);

    Department selectDeptById(Long id);
}
