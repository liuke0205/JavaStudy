package Singleton;

/**
 * @author liuke
 * @create 2021/03/31/19:31
 */

public class Singleton_懒汉式_sychroized {
    /**
     * 线程安全
     */
    private static Singleton_懒汉式_sychroized instance = null;

    public static Singleton_懒汉式_sychroized getInstance(){
        synchronized (Singleton_懒汉式_sychroized.class){
            if (instance == null){
                instance = new Singleton_懒汉式_sychroized();
            }
        }
        return instance;
    }
}