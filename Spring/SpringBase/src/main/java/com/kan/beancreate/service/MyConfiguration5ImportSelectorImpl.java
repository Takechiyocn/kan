package com.kan.beancreate.service;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Properties;

/**
 * @ClassName MyConfiguration5ImportSelectorImpl
 * @Description 实现配置文件读取，并进行相应处理。此处读取密码配置文件后解密(加解密也可通过jasypt工具)
 * @Author moku
 * @Date 2022/12/10 11:44
 * @Version 1.0
 */
public class MyConfiguration5ImportSelectorImpl implements ImportSelector, EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        if (environment.containsProperty("jdbcusername")
                && environment.containsProperty("jdbcpassword")) {
            System.out.println("加密前用户名为：" + environment.getProperty("jdbcusername"));
            System.out.println("加密前用户密码为：" + environment.getProperty("jdbcpassword"));
            MutablePropertySources sources = ((ConfigurableEnvironment)environment).getPropertySources();
            Properties p = new Properties();
            // 假设这里在做一系列AES、HS256等加密算法进行解密
            p.put("jdbcusername", "冯宝宝");
            p.put("jdbcpassword", "最大的秘密就是天师度啊~");
            sources.addFirst(new PropertiesPropertySource("defaultProperties", p));
        }
        return new String[0];
    }
}
