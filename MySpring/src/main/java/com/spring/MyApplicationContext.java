package com.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class MyApplicationContext {
    private Class configClass;

    ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();//单例池
    ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();//BeanDefinitionMap
    List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();
    public MyApplicationContext(Class configClass) throws Exception {
        this.configClass = configClass;
        scan(configClass);
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            //为所有的单例bean创建Bean
            if("singleton".equals(beanDefinition.getScope())){
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }
    }

    public Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        Class clazz = beanDefinition.getClazz();
        Object instance = clazz.getDeclaredConstructor().newInstance();

        //对属性进行赋值，依赖注入
        for (Field declaredField : clazz.getDeclaredFields()) {
            if(declaredField.isAnnotationPresent(Autowried.class)){
                Object bean = getBean(declaredField.getName());
                declaredField.setAccessible(true);
                declaredField.set(instance, bean);
            }
            //对基本类型变量进行依赖注入@Value
            if (declaredField.isAnnotationPresent(Value.class)){
                //获取该属性的Value注解的实例
                Value annotation = declaredField.getAnnotation(Value.class);
                //获取实例的value值
                String value = annotation.value();
                declaredField.setAccessible(true);
                declaredField.set(instance, value);
            }
        }
        //Aware回调
        if(instance instanceof BeanNameAware){
           ((BeanNameAware) instance).setBeanName(beanName);
        }

        //初始化之前
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
            instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
        }

        //初始化
        if(instance instanceof InitializingBean){
            ((InitializingBean) instance).afterPropertiesSet();
        }

        //初始化之后
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
            instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
        }

        return instance;
    }

    private void scan(Class configClass) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //解析配置类
        ComponentScan componentScanAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        //拿到ComponentScan注解的value
        String path = componentScanAnnotation.value();
//        System.out.println(path);
        //扫描路径，看路径下面所有文件是否有Component注解
        ClassLoader classLoader = MyApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(path.replace(".", "/"));
        File file = new File(resource.getFile());
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                String fileName = f.getAbsolutePath();
                if (fileName.endsWith(".class")) {
                    fileName = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                    fileName = fileName.replace("\\", ".");
//                    System.out.println(fileName);
                    //根据全限定类名 生成 Class对象
                    Class<?> clazz = classLoader.loadClass(fileName);
                    if(clazz.isAnnotationPresent(Component.class)){

                        if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                            BeanPostProcessor instance = (BeanPostProcessor)clazz.getDeclaredConstructor().newInstance();
                            beanPostProcessorList.add(instance);
                        }


                        //表示这个类是一个bean
                        //解析某一个类
                        Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                        //得到beanName
                        String beanName = componentAnnotation.value();
                        //对每个Component注解生成一个BeanDefinition
                        BeanDefinition beanDefinition = new BeanDefinition();
                        beanDefinition.setClazz(clazz);
                        if(clazz.isAnnotationPresent(Scope.class)){
                            Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                            String scopeName = scopeAnnotation.value();
                            beanDefinition.setScope(scopeName);
                        }else{//如果没有配置scope注解，那么默认使用单例
                            beanDefinition.setScope("singleton");
                        }
                        //判断当前bean是否为单例bean还是prototype
                        beanDefinitionMap.put(beanName, beanDefinition);
                    }
                }

            }
        }
    }

    public Object getBean(String beanName) throws Exception {
        if (beanDefinitionMap.containsKey(beanName)){
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if("singleton".equals(beanDefinition.getScope())){
                Object o = singletonObjects.get(beanName);
                return o;
            }else{
                //创建一个Bean对象
                Object bean = createBean(beanName, beanDefinition);
                return bean;
            }
        }else {
            throw new NullPointerException();
        }
    }
}
