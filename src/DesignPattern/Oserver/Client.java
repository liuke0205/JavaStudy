package Oserver;

/**
 * @author liuke
 * @create 2021/04/13/16:24
 */
public class Client {
    public static void main(String[] args) {
        CriminalObservable criminalObservable = new CriminalObservable();
        Observer policeObserver1 = new PoliceObserver();
        Observer policeObserver2 = new PoliceObserver();
        criminalObservable.addObserver(policeObserver1);
        criminalObservable.addObserver(policeObserver2);
        criminalObservable.crime("放狗要人");
    }
}
