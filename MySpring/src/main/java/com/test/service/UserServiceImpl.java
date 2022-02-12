package com.test.service;

import com.spring.*;

import java.util.stream.IntStream;

@Component("userService")
public class UserServiceImpl implements BeanNameAware, InitializingBean, UserService {
    @Autowried
    private OrderService orderService;

    private String beanName;

    @Value(value="11")
    private String num;


    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void test(){
        System.out.println(orderService);
        System.out.println(beanName);
        System.out.println(num);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("正在进行初始化......");
    }
}
