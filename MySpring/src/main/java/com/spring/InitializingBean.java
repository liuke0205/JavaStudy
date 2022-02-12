package com.spring;

public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
