package State;
/**
 * @author liuke
 * @create 2021/03/18/14:09
 */
public class Off implements State{

    @Override
    public void disp() {
        System.out.println("灯是关闭状态！");
    }

    @Override
    public void press(Light light) {
        light.setPress(new On());
    }
}
