package Singleton;

/**
 * @author liuke
 * @create 2021/03/31/19:31
 */

public class Singleton_懒汉式 {
    /**
     * 线程不安全
     */
    private static Singleton_懒汉式 instance = null;

    public static Singleton_懒汉式 getInstance(){
        if (instance == null){
            instance = new Singleton_懒汉式();
        }
        return instance;
    }
}