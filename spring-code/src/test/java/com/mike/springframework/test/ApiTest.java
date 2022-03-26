package com.mike.springframework.test;

import com.mike.springframework.beans.factory.config.BeanDefinition;
import com.mike.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.mike.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

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

    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    @Test
    public void test_parameterTypes() throws Exception {

        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructor = beanClass.getDeclaredConstructors();

        Constructor<?> constructor = declaredConstructor[0];
        Constructor<UserService> declaredConstructor1 = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService aa = declaredConstructor1.newInstance("aa");
        //
        // aa.queryUserInfo();
        System.out.println(aa);
    }

    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        Object o = enhancer.create(new Class[]{String.class}, new Object[]{"小虾皮"});
        System.out.println(o);
    }
}
