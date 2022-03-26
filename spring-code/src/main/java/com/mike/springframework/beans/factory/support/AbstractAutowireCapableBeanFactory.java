package com.mike.springframework.beans.factory.support;

import com.mike.springframework.beans.BeanException;
import com.mike.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        //return null;
        Object bean = null;

        try {
            //无参数
            bean = beanDefinition.getBeanClass().newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
