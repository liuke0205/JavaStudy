package Oserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @create 2021/04/13/16:34
 */
public class Observable {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}