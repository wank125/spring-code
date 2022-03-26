package com.mike.springframework.beans;

public class BeanException extends RuntimeException {
    private String msg;

    public BeanException(String msg) {
        super(msg);
    }

    public BeanException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
