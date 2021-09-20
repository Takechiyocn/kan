package api.entity.service.reflector;

import api.entity.reflector.Employee;
import api.mapper.reflector.EmployeeMapper;
import api.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeTest {

    private Logger logger = LoggerFactory.getLogger(EmployeeTest.class);

    @Test
    public void testSelectEmployeeByPrimaryKey() {

        SqlSession session = MyBatisFactory.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeByPrimaryKey(1L);
        logger.info("姓名：{}，部门：{}", employee.getName(),employee.getDept().getName());
    }

    @Test
    public void testSelectEmployeeByPrimaryKey2() {

        SqlSession session = MyBatisFactory.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeByPrimaryKey2(2L);
        logger.info("姓名：{}，部门：{}", employee.getName(),employee.getDept().getName());
    }
}
