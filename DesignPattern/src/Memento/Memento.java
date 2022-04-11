package Memento;

/**
 * @author liuke
 * @date 2022/4/12 0:50
 */
public class Memento {
    private String  state;
    public Memento(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
