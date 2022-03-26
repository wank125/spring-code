package com.mike.springframework.test;

import com.mike.springframework.beans.factory.config.BeanDefinition;
import com.mike.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.mike.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        //初始化
//        BeanFactory beanFactory = new BeanFactory();
//        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
//        beanFactory.regiosterBeanDefinition("userService", beanDefinition);
//
//        //获取
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.queryUserInfo();


//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//        //获取
//        UserService userServive = (UserService) beanFactory.getBean("userService");
//        userServive.queryUserInfo();
//        //第二次获取
//        UserService userServive_singleton = (UserService) beanFactory.getBean("userService");
//        userServive_singleton.queryUserInfo();


        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        beanFactory.registerBeanDefinition("userService", beanDefinition);
        UserService bean = (UserService) beanFactory.getBean("userService", "小副");
        bean.queryUserInfo();

    }
}
