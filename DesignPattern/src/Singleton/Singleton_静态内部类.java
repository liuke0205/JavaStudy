package Singleton;

/**
 * @author liuke
 * @date 2022/3/23 0:32
 */
public class Singleton_静态内部类 {
    /**
     * 线程安全
     */
    private static class SingletonHolder{
        private static Singleton_静态内部类 instance = new Singleton_静态内部类();
    }

    public static Singleton_静态内部类 getInstance(){
        return SingletonHolder.instance;
    }
}
