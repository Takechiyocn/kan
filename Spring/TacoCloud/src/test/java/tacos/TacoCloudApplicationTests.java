package tacos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ExtendWith：Junit5注解
 * Sprint Boot2.1.x后SpringBootTest包含该注解，所以无需再单独注解
 */
//@ExtendWith(SpringExtension.class)
@SpringBootTest
class TacoCloudApplicationTests {

    @Test
    void contextLoads() {
    }

}
