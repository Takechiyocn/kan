package test.java.com.moku.api.entity;

import main.java.com.moku.api.entity.Employee;
import main.java.com.moku.api.entity.User;
import main.java.com.moku.api.mapper.EmployeeMapper;
import main.java.com.moku.api.mapper.UserMapper;
import main.java.com.moku.api.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmployeeTest {

    @Test
    public void testInsert() {

        Logger logger = LoggerFactory.getLogger(EmployeeTest.class);
        SqlSession session = MyBatisUtil.openSession();

        try {
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

            Employee employee = new Employee() {{
                this.setAge(15);
            }};
            employeeMapper.insertEmployee(employee);

            // 单条记录查找：手动映射结果集和对象属性
            Employee employee2 = employeeMapper.queryOne(43L);
            if (null != employee2) {
                logger.info("Name:" + employee2.getName() + ", id:" + employee2.getId());
            }

            // 单条记录查找：手动映射结果集和对象属性
            List<Employee> employee3 = employeeMapper.queryAll();
            for (Employee e : employee3) {
                logger.info("Name:" + e.getName() + ", id:" + e.getId());
            }

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}

