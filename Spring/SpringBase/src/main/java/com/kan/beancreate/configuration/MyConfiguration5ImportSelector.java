package com.kan.beancreate.configuration;

import com.kan.beancreate.service.MyConfiguration5ImportSelectorImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName MyConfiguration5ImportSelector
 * @Description
 *              引入一个配置类(MyConfiguration5ImportSelectorImpl)
 *              同时加载配置文件 myApplication.properties
 * @Author moku
 * @Date 2022/12/10 11:34
 * @Version 1.0
 */
@Configuration
@Import(MyConfiguration5ImportSelectorImpl.class)
@PropertySource("myApplication.properties")
public class MyConfiguration5ImportSelector {
}
