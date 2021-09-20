package api.mapper.reflector;

import api.entity.reflector.Department;
import api.entity.reflector.Employee;

public interface DepartmentMapper {

    Department selectDeptById(Long id);

    Department selectDeptById2(Long id);

    Employee selectEmployeeById(Long id);
}
