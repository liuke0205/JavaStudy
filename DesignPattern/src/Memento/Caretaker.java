package Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/12 0:51
 */
public class Caretaker {
    List<Memento> list;

    public Caretaker() {
        this.list = new ArrayList<>();
    }

    public void add(Memento memento) {
        list.add(memento);
    }

    public Memento getIndex(int index) {
        return list.get(index);
    }
}
