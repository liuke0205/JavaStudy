package Memento;

/**
 * @author liuke
 * @date 2022/4/12 0:50
 */
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    //保存成备忘录对象
    public Memento saveOriginator() {
        return new Memento(state);
    }

    //通过备忘录对象，恢复状态
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
