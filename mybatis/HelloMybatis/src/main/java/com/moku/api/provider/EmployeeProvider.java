package main.java.com.moku.api.provider;

import main.java.com.moku.api.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 动态SQL注解Provider
 * @author moku
 */
public class EmployeeProvider {

//    public String queryEmployee(long userId) {
//        return new SQL() {{
//            SELECT("*");
//            FROM("employee");
//            WHERE("e_id = #{userId}");
//        }}.toString();
//    }

    public String queryMulti(Employee employee) {
        return new SQL() {{
            SELECT("*");
            FROM("employee");
            if(StringUtils.isNotBlank(employee.getName())) {
                WHERE("e_name like concat('%', #{name}, '%')");
            }
            if(null != employee.getAge()) {
                WHERE("e_age = #{age}");
            }
            if(StringUtils.isNotBlank(employee.getEmail())) {
                WHERE("e_email = #{email}");
            }
        }}.toString();
    }

    public String queryMultiCnt(Employee employee) {
        return new SQL() {{
            SELECT("count(1)");
            FROM("employee");
            if(StringUtils.isNotBlank(employee.getName())) {
                WHERE("e_name like concat('%', #{name}, '%')");
            }
            if(null != employee.getAge()) {
                WHERE("e_age = #{age}");
            }
            if(StringUtils.isNotBlank(employee.getEmail())) {
                WHERE("e_email = #{email}");
            }
        }}.toString();
    }

    public String updEmployeeByNotNull(Employee employee) {
        return new SQL() {{
            UPDATE("employee");
            if(StringUtils.isNotBlank(employee.getName())) {
                SET("e_name = #{name}");
            }
            if(null != employee.getAge()) {
                SET("e_age = #{age}");
            }
            if(StringUtils.isNotBlank(employee.getEmail())) {
                SET("e_email = #{email}");
            }
            WHERE("e_id = #{id}");
        }}.toString();
    }

    /**
     * TODO：当mapper中传入的参数是使用@param 注解修饰，在xxxProvider类中必须使用Map对象接收参数。
     * @param ids
     * @return
     */
//    public String deleteByIds(Integer[] ids) {
//        // TODO: ids空判断在哪进行？
//        StringBuilder idList = new StringBuilder("(");
//        for (int i = 0; i < ids.length; i++) {
//            if (i != 0) {
//                idList.append(" ,");
//            }
//            idList.append(ids[i]);
//        }
//        idList.append(")");
//
//        String sql = new SQL() {{
//            DELETE_FROM("employee");
//            WHERE("e_id in " + idList.toString());
//        }}.toString();
//        return new SQL() {{
//            DELETE_FROM("employee");
//            WHERE("e_id in " + idList.toString());
//        }}.toString();
//    }

//    int deleteByIds(@Param("ids")Integer[] ids);
//    int insertByBatch(@Param("users") List<Employee> users);

}
