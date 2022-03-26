package com.mike.springframework.beans.factory.config;

import com.mike.springframework.beans.PropertyValues;

public class BeanDefinition {
    private final Class beanClass;
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this(beanClass, new PropertyValues());
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
