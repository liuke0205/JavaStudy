/**
 * @author LiuKe
 * @create 2021-09-08 11:00
 */
package com.spring;

public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName);
    Object postProcessAfterInitialization(Object bean, String beanName);

}
