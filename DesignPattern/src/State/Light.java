package State;

/**
 * @author liuke
 * @create 2021/03/18/14:07
 */
public class Light {
    State state;

    public void setPress(State state){
        this.state = state;
    }
    public void disp(){
        this.state.disp();
    }
}