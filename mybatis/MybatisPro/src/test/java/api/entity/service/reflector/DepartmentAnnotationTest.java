package api.entity.service.reflector;

import api.entity.reflector.Department;
import api.entity.reflector.Employee;
import api.mapper.reflector.DepartmentAnnotationMapper;
import api.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepartmentAnnotationTest {

    private Logger logger = LoggerFactory.getLogger(DepartmentAnnotationTest.class);

    @Test
    public void testSelectDepartmentByPrimaryKey() {

        SqlSession session = MyBatisFactory.getSession();
        DepartmentAnnotationMapper mapper = session.getMapper(DepartmentAnnotationMapper.class);
        Department department = mapper.selectDeptById(1L);
        for (Employee emp : department.getEmps()) {
            logger.info("部门：{}，姓名：{}", department.getName(),emp.getName());
        }
    }
}
