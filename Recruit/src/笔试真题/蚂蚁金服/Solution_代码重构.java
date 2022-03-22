package 笔试真题.蚂蚁金服;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuke
 * @date 2022/3/23 0:15
 */
public class Solution_代码重构 {
    /**
     * 重构以下代码
     * @param code
     */
    public void handle(int code){
        if (code == 1){
            fun1();
        }else if (code == 2){
            fun2();
        }else if (code == 3){
            fun3();
        }else {
            defaultFun();
        }
    }
    private void fun1() { }
    private void fun2() { }
    private void fun3() { }
    private void defaultFun() { }
}


/**
 * 使用工厂模式重构
 */
class Refactor{
    public void handle(int code){
        Fun fun = FunFactory.getFun(code);
        fun.fun();
    }
}


class FunFactory{
    static Map<Integer, Fun> map = new HashMap<>();
    static {
        map.put(1, new Fun1());
        map.put(2, new Fun2());
        map.put(3, new Fun2());
    }

    public static Fun getFun(int code){
        return map.getOrDefault(code, new DefaultFun());
    }
}


interface Fun{
    void fun();
}

class Fun1 implements Fun{
    @Override
    public void fun() {}
}

class Fun2 implements Fun{
    @Override
    public void fun() {}
}

class Fun3 implements Fun{
    @Override
    public void fun() {}
}

class DefaultFun implements Fun{
    @Override
    public void fun() {}
}

