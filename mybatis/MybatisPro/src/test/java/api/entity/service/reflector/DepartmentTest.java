package api.entity.service.reflector;

import api.entity.reflector.Department;
import api.entity.reflector.Employee;
import api.mapper.reflector.DepartmentMapper;
import api.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepartmentTest {

    private Logger logger = LoggerFactory.getLogger(DepartmentTest.class);

    @Test
    public void testSelectDepartmentByPrimaryKey() {

        SqlSession session = MyBatisFactory.getSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department department = mapper.selectDeptById(1L);
        for (Employee emp : department.getEmps()) {
            logger.info("部门：{}，姓名：{}", department.getName(),emp.getName());
        }
    }

    @Test
    public void testSelectDepartmentByPrimaryKey2() {

        SqlSession session = MyBatisFactory.getSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department department = mapper.selectDeptById2(1L);
        for (Employee emp : department.getEmps()) {
            logger.info("部门：{}，姓名：{}", department.getName(),emp.getName());
        }
    }
}
