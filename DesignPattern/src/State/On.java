package State;

/**
 * @author liuke
 * @create 2021/03/18/14:09
 */
public class On implements State{

    @Override
    public void disp() {
        System.out.println("灯是打开状态！");
    }

    @Override
    public void press(Light light) {
        light.setPress(new Off());
    }
}
