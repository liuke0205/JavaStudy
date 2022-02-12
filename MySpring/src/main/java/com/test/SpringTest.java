package com.test;

import com.spring.MyApplicationContext;
import com.test.service.UserService;
import com.test.service.UserServiceImpl;

public class SpringTest {
    public static void main(String[] args) throws Exception {
        MyApplicationContext applicationContext = new MyApplicationContext(AppConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();
    }
}
