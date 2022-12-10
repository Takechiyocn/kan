package com.kan.beancreate.configuration;

import com.kan.beancreate.entity.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName MyImport
 * @Description 4. 基于@Configuration、@Import注解方式
 *              Spring容器中没有Customer对象，Import引入
 * @Author moku
 * @Date 2022/12/10 11:04
 * @Version 1.0
 */
@Configuration
@Import(Customer.class)
public class MyConfiguration4Import {
}
