package com.mike.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.mike.springframework.beans.core.io.DefaultResourceLoader;
import com.mike.springframework.beans.core.io.Resource;
import com.mike.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.mike.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.mike.springframework.test.bean.UserService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ResourceLoadTest {
    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    public void test_file() throws IOException {
        resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    void test_url() throws IOException {
//        resourceLoader = new DefaultResourceLoader();
//        Resource resource = resourceLoader.getResource("https://github.com/wank125/small-spring/tree/main/small-spring-step-06/src/test/resources/important.properties");
//        InputStream inputStream = resource.getInputStream();
//        String s = IoUtil.readUtf8(inputStream);
//        System.out.println(s);
    }

    @Test
    public void test_xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //读取配置文件
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String s = userService.queryUserInfo();
        System.out.println(s);


    }
}
