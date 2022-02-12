package Singleton;

/**
 * @author liuke
 * @create 2021/03/31/19:31
 */

/*
懒汉式+线程安全
 */
public class Singleton3 {
    private static Singleton3 instance = null;
    private Singleton3() {
    }
    public static Singleton3 getInstance(){
        synchronized (Singleton3.class){
            if(instance == null){
                instance = new Singleton3();
            }
        }
        return instance;
    }
}