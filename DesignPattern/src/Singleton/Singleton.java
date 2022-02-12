package Singleton;

/**
 * @author liuke
 * @create 2021/03/31/19:31
 */

/*
懒汉式
 */
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {
    }
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}