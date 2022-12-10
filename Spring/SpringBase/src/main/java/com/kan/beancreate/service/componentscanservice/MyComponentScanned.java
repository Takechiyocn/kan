package com.kan.beancreate.service.componentscanservice;

import com.kan.beancreate.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyConf
 * @Description
 * @Author moku
 * @Date 2022/12/10 2:15
 * @Version 1.0
 */
@Component
//@Controller:标注控制层组件
//@Service:标注业务层组件
//@Repository:标注DAO层，在daoImpl上面注解
public class MyComponentScanned {
    /**
     * 定义一个类，将这个类交给Spring管理
     *
     * @Component @Controller @Service @Repository
     * 使用的效果是一样的，都会在扫描包时，将当前类交给Spring管理
     */
    @Bean
    public Customer customerScannedComponent() {
        return new Customer("无根生", 150);
    }
}
