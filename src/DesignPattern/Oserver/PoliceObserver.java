package Oserver;

import java.util.Observable;

/**
 * @author liuke
 * @create 2021/04/13/16:21
 */
public class PoliceObserver implements Observer {
    @Override
    public void update(String arg) {
        System.out.println("警察收到消息，罪犯在" + arg);
    }
}
