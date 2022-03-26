package com.mike.springframework.beans.factory.support;

import com.mike.springframework.beans.BeanException;
import com.mike.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclasssingInstantiationStrategy();


    public Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {

        Object bean = null;
        bean = createBeanInstance(beanDefinition, beanName, args);
        addSingleton(beanName, bean);
        return bean;
    }


    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor = null;

        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructor = beanClass.getDeclaredConstructors();


        for (Constructor c : declaredConstructor) {
            if (null != args && c.getParameterTypes().length == args.length) {
                constructor = c;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);


    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
