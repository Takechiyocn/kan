package main.java.com.moku.api.mapper;

import main.java.com.moku.api.entity.Employee;
//import main.java.com.moku.api.mapper.provider.AnnotationProvider;
import main.java.com.moku.api.mapper.provider.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 动态SQL：基于注解
 * 总结：有无Param注解，均可以使用多个参数
 *      1.不使用Param注解时，无限制
 *      2.当使用Param注解时
 *        前提：provider传递的参数要也要进行Param注解。且mapper传递的注解名和provider中的注解名一致。
 *        a. 当传递数组时，provider接收参数时默认使用arg0和arg1，
 *           数组实例将会以"array"作为默认键，导致provider不注解别名，MyBatis无法识别。
 *        b. 当传递list时，SQL映射时(即处理OGNL处)必须使用注解别名。
 *           原因：MyBatis会自动将参数包装在一个Map中,用名称作为键。List实例将会以"list" 作为默认键。
 *
 * @author moku
 */
public interface AnnotationProviderMapper {

    /**
     * 根据条件查询结果(ResultMap中的第一条记录)
     *
     * @param employeeId
     * @return
     */
    @SelectProvider(type = AnnotationProvider.class, method = "queryEmployee")
    @ResultMap("annotation_employee_map")
    Employee getEmployee(long employeeId);

    /**
     * 根据条件查询结果(ResultMap中的所有记录)
     *
     * @param employee
     * @return
     */
    @SelectProvider(type = AnnotationProvider.class, method = "queryMulti")
    @ResultMap("annotation_employee_map")
    List<Employee> queryMultiEmployee(Employee employee);

    /**
     * 根据条件查询结果总数
     *
     * @param employee
     * @return
     */
    @SelectProvider(type = AnnotationProvider.class, method = "queryMultiCnt")
    Long queryMultiEmployeeCount(Employee employee);

    /**
     * 修改用户，参数不为空的数据才会修改
     *
     * @param employee
     * @return
     */
    @UpdateProvider(type = AnnotationProvider.class, method = "updEmployeeByNotNull")
    int updateEmployeeByNotNull(Employee employee);

    /**
     * 根据条件查询结果：多个参数
     *
     * @param id1
     * @param id2
     * @param id3
     * @return
     */
    @SelectProvider(type = AnnotationProvider.class, method = "queryMultiEmployeeByMultiParameters")
    @ResultMap("annotation_employee_map")
    List<Employee> queryMultiEmployeeByMultiParameters(Integer id1, Integer id2, Integer id3);

    /**
     * 根据条件查询结果：参数为数组
     *
     * @param idList
     * @return
     */
    @SelectProvider(type = AnnotationProvider.class, method = "queryMultiEmployeeByArrays")
    @ResultMap("annotation_employee_map")
    List<Employee> queryMultiEmployeeByArrays(Integer[] idList);

    /**
     * 根据条件查询结果：参数为list
     *
     * @param employeeList
     * @return
     */
    @SelectProvider(type = AnnotationProvider.class, method = "queryMultiEmployeeByList")
    @ResultMap("annotation_employee_map")
    List<Employee> queryMultiEmployeeByList(List<Employee> employeeList);

    /**
     * 批量删除用户
     *
     * @param idList
     * @return
     */
    @DeleteProvider(type = AnnotationProvider.class, method = "deleteByIds")
    int deleteByIds(@Param("ids")Integer[] idList);

    /**
     * 批量插入
     * 注释别名：@Param("employees")。
     * provider别名和SQL映射时(即处理OGNL)使用变量名(非普通参数处理)时，必须使用注解别名
     *
     * @param employeeList
     * @return
     */
    @Insert("<script> INSERT INTO employee "
            + "(e_id, e_name, e_age, e_email) "
            + "VALUES "
            + "<foreach collection = 'employees' item='record' separator=',' > "
            + " (#{record.id}, "
            + " #{record.name},"
            + " #{record.age},"
            + " #{record.email}) "
            + "</foreach> "
            + "</script>")
    int insertByBatch(@Param("employees") List<Employee> employeeList);

    /**
     *
     * 如果注释别名是list时，@Param("list") 可以省略，在处理list的时候默认是list
     *
     * @param employeeList
     * @return
     */
    @InsertProvider(type = AnnotationProvider.class, method = "insertByBatch2")
    int insertByBatch2(@Param("employees") List<Employee> employeeList);

    /**
     * 批量删除用户
     * 参数为多个
     *
     * @param idList
     * @param id2
     * @param id3
     * @return
     */
    @SelectProvider(type = AnnotationProvider.class, method = "getByIdsWithMultiParameter")
    @ResultMap("annotation_employee_map")
    List<Employee> getByIdsWithMultiParameter(@Param("ids")Integer[] idList, @Param("id2add") Integer id2, @Param("id3add") Integer id3);
}
