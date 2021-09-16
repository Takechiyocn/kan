package main.java.com.moku.api.mapper;

import main.java.com.moku.api.entity.Employee;
import main.java.com.moku.api.provider.EmployeeProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 动态SQL：基于注解
 *
 * @author moku
 */
public interface AnnotationProviderMapper {

//    @SelectProvider(type = EmployeeProvider.class, method = "queryEmployee")
//    @ResultMap("Employee")
//    Employee getEmployee(long employeeId);

    /**
     * 根据条件查询结果
     *
     * @param employee
     * @return
     */
    @SelectProvider(type = EmployeeProvider.class, method = "queryMulti")
    @ResultMap("annotation_employee_map")
    List<Employee> queryMultiEmployee(Employee employee);

    /**
     * 根据条件查询结果总数
     *
     * @param employee
     * @return
     */
    @SelectProvider(type = EmployeeProvider.class, method = "queryMultiCnt")
    Long queryMultiEmployeeCount(Employee employee);

    /**
     * 修改用户,参数不为空的数据才会修改
     *
     * @param employee
     * @return
     */
    @UpdateProvider(type = EmployeeProvider.class, method = "updEmployeeByNotNull")
    int updateEmployeeByNotNull(Employee employee);

    /**
     * 批量删除用户
     *
     * @param ids
     * @return
     */
//    @DeleteProvider(type = EmployeeProvider.class, method = "deleteByIds")
//    int deleteByIds(@Param("ids")Integer[] ids);
//    int deleteByIds(Map map);

//    /**
//     * 批量插入
//     *
//     * @param employees
//     * @return
//     */
//    @InsertProvider(type = EmployeeProvider.class, method = "insertByBatch")
//    int insertByBatch(@Param("employees") List<Employee> employees);
}
