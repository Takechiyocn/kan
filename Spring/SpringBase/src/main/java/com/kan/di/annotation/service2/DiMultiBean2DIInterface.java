package com.kan.di.annotation.service2;

import com.kan.di.annotation.interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName DiMultiBean2DIInterface
 * @Description
 * @Author moku
 * @Date 2022/12/11 23:01
 * @Version 1.0
 */
@Service
public class DiMultiBean2DIInterface {
    @Autowired
    // 消除由于多个接口实现带来的歧义
    //   1. @Qualifier注解
    //   2. @Primary注解：在接口实现类上注解即可
//    @Qualifier("diMultiBean2Impl1")
    private IUser user;
}
