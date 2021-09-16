package test.java.com.moku.api.entity;

import main.java.com.moku.api.entity.Employee;
import main.java.com.moku.api.entity.Employee;
import main.java.com.moku.api.mapper.AnnotationProviderMapper;
import main.java.com.moku.api.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provider test
 *
 * @author moku
 */
public class AnnotationProviderTest {

    private Logger logger = LoggerFactory.getLogger(AnnotationProviderTest.class);
    private SqlSession session = MyBatisUtil.openSession();
    private AnnotationProviderMapper mapper = session.getMapper(AnnotationProviderMapper.class);

//    @Test
//    public void queryOne() {
//
//        long id = 20L;
//        Employee employee = mapper.getEmployee(id);
//        logger.info("Name:{}, Age:{}, Email:{}", employee.getName(), employee.getAge(), employee.getEmail());
//    }

    @Test
    public void testQueryMultiEmployee() {

        // 根据条件查询结果
        Employee employee = new Employee() {{
            this.setName("moku");
            this.setAge(15);
        }};
        List<Employee> employeeList = mapper.queryMultiEmployee(employee);
        for (Employee e : employeeList) {
            logger.info("Name:{}, Age:{}, Email:{}", e.getName(), e.getAge(), e.getEmail());
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

//    @Test
//    public void testDeleteByIds() {
//
//        // 批量删除
//        int delCnt = mapper.deleteByIds(new Integer[]{74, 75});
//        logger.info("Deleted Count {}", delCnt);
//    }

//    @Test
//    public void testInsertByBatch() {
//        // 批量插入
//        List<Employee> employeeList2 = new ArrayList<>() {{
//            add(new Employee() {{
//                this.setName("batchEmployee");
//                this.setAge(20);
//                this.setEmail("email1");
//                this.setPassword("pwd1");
//            }});
//            add(new Employee() {{
//                this.setName("batchEmployee2");
//                this.setAge(21);
//                this.setEmail("email2");
//                this.setPassword("pwd2");
//            }});
//            add(new Employee() {{
//                this.setName("batchEmployee3");
//                this.setAge(22);
//                this.setEmail("email3");
//                this.setPassword("pwd3");
//            }});
//        }};
//        int insCnt = mapper.insertByBatch(employeeList2);
//        logger.info("BatchInsert Count {}", insCnt);
//
//        session.commit();
//    }
}
