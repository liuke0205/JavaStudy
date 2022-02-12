package Singleton;

/**
 * @author liuke
 * @create 2021/03/31/19:31
 */

/*
静态内部类
 */
public class Singleton5 {
    private static class SingletonHolder{
        private static Singleton5 instance = new Singleton5();
    }
    private Singleton5() {
    }
    public static Singleton5 getInstance(){
        return SingletonHolder.instance;
    }
}