package Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/9 16:52
 */
public abstract class Subject {
    private List<Observer> observerList = new ArrayList<>();
    public void attach(Observer observer){
        observerList.add(observer);
        System.out.println("增加了观察者：" + observer.getName());
    }

    public void dettach(Observer observer){
        observerList.remove(observer);
        System.out.println("删除了观察者：" + observer.getName());
    }
    
    public void notifyObserver(){
        for (Observer observer : observerList) {
            observer.update("灰太狼要搞事情了！");
        }
    }
}
