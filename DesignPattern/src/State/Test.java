package State;

/**
 * @author liuke
 * @create 2021/03/18/14:15
 */
public class Test {
    public static void main(String[] args) {
        Light light=new Light();
        State state=new On();
        light.setPress(state);
        System.out.print("现在是:");
        light.disp();
        System.out.print("按下开关后是:");
        state.press(light);
        light.disp();
    }
}