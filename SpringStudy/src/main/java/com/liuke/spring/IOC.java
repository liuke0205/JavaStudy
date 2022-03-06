package com.liuke.spring;

/**
 * @author liuke
 * @date 2022/3/6 20:31
 */
public class IOC {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        BaseService baseService = Factory.getBean("com.liuke.spring.BaseService");
        System.out.println(baseService.hashCode());
    }
}

class Factory{
    public static BaseService getBean(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        BaseService baseService;
        baseService = (BaseService) Class.forName(className).newInstance();
        return baseService;
    }
}
