package Memento;

/**
 * @author liuke
 * @date 2022/4/12 0:51
 */
public class MementoTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("状态0：战斗力100");
        caretaker.add(originator.saveOriginator());

        originator.setState("状态1：战斗力80");
        caretaker.add(originator.saveOriginator());

        System.out.println("=================当前状态===================");
        System.out.println(originator.getState());

        System.out.println("==============恢复到最初状态===============");
        originator.getStateFromMemento(caretaker.getIndex(0));
        System.out.println(originator.getState());
    }
}
