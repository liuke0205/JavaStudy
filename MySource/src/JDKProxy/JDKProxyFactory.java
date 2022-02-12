package JDKProxy;

import java.lang.reflect.Proxy;

public class JDKProxyFactory {


    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //目标类的类加载
                target.getClass().getInterfaces(),  //代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)  //代理对象自定义的InvocationHandler
        );
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService)JDKProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}

