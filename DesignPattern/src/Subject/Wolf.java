package Subject;

/**
 * @author liuke
 * @date 2022/4/9 17:29
 */
public class Wolf extends Subject {
    public void invade(){
        System.out.println("灰太狼：我要搞事情了");
        // 通知所有观察者
        notifyObserver();
    }
}
