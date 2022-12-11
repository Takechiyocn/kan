package com.kan.di.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @ClassName DiMultiBean1Service2
 * @Description
 * @Author moku
 * @Date 2022/12/11 22:04
 * @Version 1.0
 */
@Service
public class DiMultiBean1Service2 {

    // DiMultiBean1Service1类型Bean在DiMultiBean1Configuration被注解成t1、t2两个
    @Autowired
    // 通过Qualifier消除歧义
    @Qualifier("t1")
    private DiMultiBean1Service1 diMultiBean1Service1;

    public void test2() {
    }
}
