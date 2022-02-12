package JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DebugInvocationHandler implements InvocationHandler {
    private final Object target;
    public DebugInvocationHandler(Object o){
        target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法前，添加自己的操作
        System.out.println("before method" + method.getName());
        Object res = method.invoke(target, args);
        //调用方法后，添加自己的操作
        System.out.println("after method" + method.getName());
        return res;
    }
}
