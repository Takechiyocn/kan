package com.kan.beancreate.service.factorybeanservice;

import com.kan.beancreate.entity.Customer;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyFactoryBean
 * @Description
 * @Author moku
 * @Date 2022/12/10 14:41
 * @Version 1.0
 */
@Component
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Customer();
    }

    @Override
    public Class<?> getObjectType() {
        return Customer.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
