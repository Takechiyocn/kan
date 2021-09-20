package api.entity.service.reflector;

import api.entity.reflector.Employee;
import api.mapper.reflector.EmployeeAnnotationMapper;
import api.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeAnnotationTest {

    private Logger logger = LoggerFactory.getLogger(EmployeeAnnotationTest.class);

    @Test
    public void testSelectEmployeeByPrimaryKey() {

        SqlSession session = MyBatisFactory.getSession();
        EmployeeAnnotationMapper mapper = session.getMapper(EmployeeAnnotationMapper.class);
        Employee employee = mapper.selectEmployeeByPrimaryKey(1L);
        logger.info("姓名：{}，部门：{}", employee.getName(),employee.getDept().getName());
    }
}
