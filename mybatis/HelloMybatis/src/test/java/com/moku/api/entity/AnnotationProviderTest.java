package test.java.com.moku.api.entity;

import main.java.com.moku.api.entity.Employee;
import main.java.com.moku.api.mapper.AnnotationProviderMapper;
import main.java.com.moku.api.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Provider test
 *
 * @author moku
 */
public class AnnotationProviderTest {

    private Logger logger = LoggerFactory.getLogger(AnnotationProviderTest.class);
    private SqlSession session = MyBatisUtil.openSession();
    private AnnotationProviderMapper mapper = session.getMapper(AnnotationProviderMapper.class);

    @Test
    public void queryOne() {

        long id = 50L;
        Employee employee = mapper.getEmployee(id);
        logger.info("Id:{}, Name:{}, Age:{}, Email:{}", employee.getId(), employee.getName(), employee.getAge(), employee.getEmail());
    }

    @Test
    public void testQueryMultiEmployee() {

        // 根据条件查询结果
        Employee employee = new Employee() {{
            this.setName("moku");
            this.setAge(15);
        }};
        List<Employee> employeeList = mapper.queryMultiEmployee(employee);
        for (Employee e : employeeList) {
            logger.info("Id:{}, Name:{}, Age:{}, Email:{}", e.getId(), e.getName(), e.getAge(), e.getEmail());
        }
        session.close();
    }

    @Test
    public void testQueryMultiEmployeeCount() {

        // 根据条件查询结果总数
        Employee employee = new Employee() {{
            this.setName("moku");
            this.setAge(15);
        }};
        long employeeCount = mapper.queryMultiEmployeeCount(employee);
        logger.info("Query Count {}", employeeCount);
        session.close();
    }

    @Test
    public void testUpdateEmployeeByNotNull() {

        // 修改用户
        Employee employee = new Employee() {{
            this.setId(71L);
            this.setName("updated");
            this.setAge(18);
        }};
        int updCnt = mapper.updateEmployeeByNotNull(employee);
        logger.info("Updated Count {}", updCnt);

        session.commit();
        session.close();
    }

    @Test
    public void testQueryMultiEmployeeByMultiParameters() {

        // 根据条件查询结果
        List<Employee> employees = mapper.queryMultiEmployeeByMultiParameters(100, 101, 102);
        for (Employee e : employees) {
            logger.info("Id:{}, Name:{}, Age:{}, Email:{}", e.getId(), e.getName(), e.getAge(), e.getEmail());
        }

        session.commit();
        session.close();
    }

    @Test
    public void testQueryMultiEmployeeByArrays() {

        // 根据条件查询结果
        List<Employee> employees = mapper.queryMultiEmployeeByArrays(new Integer[]{90, 91});
        for (Employee e : employees) {
            logger.info("Id:{}, Name:{}, Age:{}, Email:{}", e.getId(), e.getName(), e.getAge(), e.getEmail());
        }

        session.commit();
        session.close();
    }

    @Test
    public void testQueryMultiEmployeeList() {

        // 根据条件查询结果
        List<Employee> employeeList = new ArrayList<>() {{
            add(new Employee() {{
                this.setId(41L);
            }});
            add(new Employee() {{
                this.setId(42L);
            }});
        }};
        List<Employee> employeeListResult = mapper.queryMultiEmployeeByList(employeeList);
        for (Employee e : employeeListResult) {
            logger.info("Id:{}, Name:{}, Age:{}, Email:{}", e.getId(), e.getName(), e.getAge(), e.getEmail());
        }
        session.close();
    }

    @Test
    public void testDeleteByIds() {

        // 批量删除
        int delCnt = mapper.deleteByIds(new Integer[]{74, 75});
        logger.info("Deleted Count {}", delCnt);

        session.commit();
        session.close();
    }

    @Test
    public void testInsertByBatch() {

        // 批量插入
        List<Employee> employees = new ArrayList<>() {{
            add(new Employee() {{
                this.setName("batchEmployee");
                this.setAge(20);
                this.setEmail("email1");
            }});
            add(new Employee() {{
                this.setName("batchEmployee2");
                this.setAge(21);
                this.setEmail("email2");
            }});
        }};
        int insCnt = mapper.insertByBatch(employees);
        logger.info("BatchInsert Count {}", insCnt);

        session.commit();
        session.close();
    }

    @Test
    public void testInsertByBatch2() {

        // 批量插入
        List<Employee> employeeList = new ArrayList<>() {{
            add(new Employee() {{
                this.setName("batch2Employee");
                this.setAge(20);
                this.setEmail("email1");
            }});
            add(new Employee() {{
                this.setName("batch2Employee2");
                this.setAge(21);
                this.setEmail("email2");
            }});
        }};
        int insCnt = mapper.insertByBatch2(employeeList);
        logger.info("BatchInsert2 Count {}", insCnt);

        session.commit();
        session.close();
    }

    @Test
    public void testGetByIdsWithMultiParameter() {

        // 批量查找
        List<Employee> employeeListResult = mapper.getByIdsWithMultiParameter(new Integer[]{101, 102}, 103, 104);
        for (Employee e : employeeListResult) {
            logger.info("Id:{}, Name:{}, Age:{}, Email:{}", e.getId(), e.getName(), e.getAge(), e.getEmail());
        }

        session.close();
    }
}
