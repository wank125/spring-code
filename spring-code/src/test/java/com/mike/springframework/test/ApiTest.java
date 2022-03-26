package com.mike.springframework.test;

import com.mike.springframework.BeanDefinition;
import com.mike.springframework.BeanFactory;
import com.mike.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        //初始化
        BeanFactory beanFactory = new BeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.regiosterBeanDefinition("userService", beanDefinition);

        //获取
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
