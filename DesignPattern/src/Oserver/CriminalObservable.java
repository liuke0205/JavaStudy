package Oserver;


/**
 * @author liuke
 * @create 2021/04/13/16:23
 */
public class CriminalObservable extends Observable {
    public void crime(String event) {
        System.out.println("罪犯正在" + event);
        notifyObservers(event);
    }
}
