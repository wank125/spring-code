package com.mike.springframework.beans.factory.support;

import com.mike.springframework.beans.BeanException;
import com.mike.springframework.beans.factory.BeanFactory;
import com.mike.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return doGetBean(name, args);
    }

    //// TODO: 2022/3/26 这个泛型没撒用？ 
    protected <T> T doGetBean(final String name, final Object[] args) {
        Object singleton = getSingleton(name);
        if (singleton != null) {
            return (T) singleton;
        }
        BeanDefinition beanDefiniton = getBeanDefiniton(name);
        return (T) createBean(name, beanDefiniton, args);
    }

    protected abstract BeanDefinition getBeanDefiniton(String beanName) throws BeanException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException;
}
