package Singleton;

/**
 * @author liuke
 * @create 2021/03/31/19:31
 */

/*
懒汉式+线程安全+双重校验
 */
public class Singleton_饿汉式 {
    private static Singleton_饿汉式 instance = new Singleton_饿汉式();
    public static Singleton_饿汉式 getInstance(){
        return instance;
    }
}