package Singleton;

/**
 * @author liuke
 * @create 2021/03/31/19:31
 */

/*
懒汉式+线程安全+双重校验
 */
public class Singleton_双重检查锁 {
    private static Singleton_双重检查锁 instance = null;
    private Singleton_双重检查锁() {
    }
    public static Singleton_双重检查锁 getInstance(){
        if(instance == null){
            synchronized (Singleton_双重检查锁.class){
                instance = new Singleton_双重检查锁();
            }
        }
        return instance;
    }
}