package com.kan.di.annotation.service2;

import com.kan.di.annotation.interfaces.IUser;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @ClassName DiMultiBean2Impl1
 * @Description
 * @Author moku
 * @Date 2022/12/11 22:58
 * @Version 1.0
 */
@Primary
@Service
public class DiMultiBean2Impl1 implements IUser {
    @Override
    public void say() {
    }
}
