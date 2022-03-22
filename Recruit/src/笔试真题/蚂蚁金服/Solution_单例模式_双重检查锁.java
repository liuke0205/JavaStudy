package 笔试真题.蚂蚁金服;

/**
 * @author liuke
 * @date 2022/3/23 0:25
 */
public class Solution_单例模式_双重检查锁 {

}

class Singleton{
    private static volatile Singleton instance = null;
    private Singleton(){}

    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
