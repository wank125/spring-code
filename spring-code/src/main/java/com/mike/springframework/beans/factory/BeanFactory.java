package com.mike.springframework.beans.factory;

import com.mike.springframework.beans.BeanException;

public interface BeanFactory {
    /**
     * 无参构造
     */
    Object getBean(String name) throws BeanException;

    /**
     * 参数构造
     */
    Object getBean(String name, Object... args) throws BeanException;
}
