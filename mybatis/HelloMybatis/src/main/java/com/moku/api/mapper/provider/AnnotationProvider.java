package main.java.com.moku.api.mapper.provider;

import main.java.com.moku.api.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.List;

/**
 * 动态SQL注解Provider
 *
 * @author moku
 */
public class AnnotationProvider {

    public String queryEmployee(long userId) {

        return new SQL() {{
            SELECT("*");
            FROM("employee");
            WHERE("e_id = #{userId}");
        }}.toString();
    }

    public String queryMulti(Employee employee) {

        return new SQL() {{
            SELECT("*");
            FROM("employee");
            if (StringUtils.isNotBlank(employee.getName())) {
                WHERE("e_name like concat('%', #{name}, '%')");
            }
            if (null != employee.getAge()) {
                WHERE("e_age = #{age}");
            }
            if (StringUtils.isNotBlank(employee.getEmail())) {
                WHERE("e_email = #{email}");
            }
        }}.toString();
    }

    public String queryMultiCnt(Employee employee) {

        return new SQL() {{
            SELECT("count(1)");
            FROM("employee");
            if (StringUtils.isNotBlank(employee.getName())) {
                WHERE("e_name like concat('%', #{name}, '%')");
            }
            if (null != employee.getAge()) {
                WHERE("e_age = #{age}");
            }
            if (StringUtils.isNotBlank(employee.getEmail())) {
                WHERE("e_email = #{email}");
            }
        }}.toString();
    }

    public String updEmployeeByNotNull(Employee employee) {

        return new SQL() {{
            UPDATE("employee");
            if (StringUtils.isNotBlank(employee.getName())) {
                SET("e_name = #{name}");
            }
            if (null != employee.getAge()) {
                SET("e_age = #{age}");
            }
            if (StringUtils.isNotBlank(employee.getEmail())) {
                SET("e_email = #{email}");
            }
            WHERE("e_id = #{id}");
        }}.toString();
    }

    /**
     * SQLProvider参数：数组类型
     *
     * @param id1
     * @param id2
     * @param id3
     * @return
     */
    public String queryMultiEmployeeByMultiParameters(Integer id1, Integer id2, Integer id3) {

        StringBuilder idList = new StringBuilder("(");
        idList.append(id1);
        idList.append(id2);
        idList.append(id3);
        idList.append(")");
        return new SQL() {{
            SELECT("*");
            FROM("employee");
            WHERE("e_id in " + idList.toString());

        }}.toString();
    }

    /**
     * SQLProvider参数：数组类型
     *
     * @param ids
     * @return
     */
    public String queryMultiEmployeeByArrays(Integer[] ids) {

        StringBuilder idList = new StringBuilder("(");
        for (int i = 0; i < ids.length; i++) {
            idList.append(ids[i]);
            if (i < ids.length - 1) {
                idList.append(" ,");
            }
        }
        idList.append(")");
        return new SQL() {{
            SELECT("*");
            FROM("employee");
            WHERE("e_id in " + idList.toString());

        }}.toString();
    }

    /**
     * SQLProvider参数：list类型
     *
     * @param employees
     * @return
     */
    public String queryMultiEmployeeByList(List<Employee> employees) {

        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < employees.size(); i++) {
            sb.append(employees.get(i).getId());
            if (i < employees.size() - 1) {
                sb.append(" ,");
            }
        }
        sb.append(")");
        return new SQL() {{
            SELECT("*");
            FROM("employee");
            WHERE("e_id in " + sb.toString());

        }}.toString();
    }

    /**
     * @param idList
     * @return
     */
    public String deleteByIds(@Param("ids") Integer[] idList) {

        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < idList.length; i++) {
            if (i != 0) {
                sb.append(" ,");
            }
            sb.append(idList[i]);
        }
        sb.append(")");

        return new SQL() {{
            DELETE_FROM("employee");
            WHERE("e_id in " + sb.toString());
        }}.toString();
    }

    public String insertByBatch2(@Param("employees") List<Employee> employeeList) {

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO employee (e_name, e_age, e_email) ");
        sb.append("VALUES");
        // #{list[0].name}:从List参数的取第0个元素的name的值
        MessageFormat mf = new MessageFormat("(#'{'employees[{0}].name},#'{'employees[{0}].age}, #'{'employees[{0}].email})");
        for (int i = 0; i < employeeList.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < employeeList.size() - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }

    public String getByIdsWithMultiParameter(
            @Param("ids") Integer[] idList,
            @Param("id2add") Integer id2tmp,
            @Param("id3add") Integer id3tmp) {

        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < idList.length; i++) {
            sb.append(idList[i]);
            if (i < idList.length - 1) {
                sb.append(" ,");
            }
        }
        sb.append(" ,");
        sb.append(id2tmp);
        sb.append(" ,");
        sb.append(id3tmp);
        sb.append(")");

        return new SQL() {{
            SELECT("*");
            FROM("employee");
            WHERE("e_id in " + sb.toString());
        }}.toString();
    }
}
