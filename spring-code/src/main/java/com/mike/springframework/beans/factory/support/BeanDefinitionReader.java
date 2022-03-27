package com.mike.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import com.mike.springframework.beans.core.io.Resource;
import com.mike.springframework.beans.core.io.ResourceLoader;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeanException;

    void loadBeanDefinitions(Resource... resources) throws BeanException;

    void loadBeanDefinitions(String loaction) throws BeanException;
}
