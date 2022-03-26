package com.mike.springframework.beans.factory.support;

import com.mike.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    Map<String, Object> singletonObjets = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjets.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjets.put(beanName, singletonObject);
    }
}
