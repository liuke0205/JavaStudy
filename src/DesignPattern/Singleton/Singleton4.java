package Singleton;

/**
 * @author liuke
 * @create 2021/03/31/19:31
 */

/*
懒汉式+线程安全+双重校验
 */
public class Singleton4 {
    private static Singleton4 instance = null;
    private Singleton4() {
    }
    public static Singleton4 getInstance(){
        if(instance == null){
            synchronized (Singleton4.class){
                instance = new Singleton4();
            }
        }
        return instance;
    }
}