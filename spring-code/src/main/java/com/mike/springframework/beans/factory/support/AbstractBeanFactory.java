package com.mike.springframework.beans.factory.support;

import com.mike.springframework.beans.BeanException;
import com.mike.springframework.beans.factory.BeanFactory;
import com.mike.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {

        Object singleton = getSingleton(name);
        if (singleton != null) {
            return singleton;
        }
        BeanDefinition beanDefiniton = getBeanDefiniton(name);
        return createBean(name, beanDefiniton);

    }

    protected abstract BeanDefinition getBeanDefiniton(String beanName) throws BeanException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException;
}
