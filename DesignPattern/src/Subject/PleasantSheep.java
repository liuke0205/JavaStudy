package Subject;

/**
 * @author liuke
 * @date 2022/4/9 17:27
 */
public class PleasantSheep implements Observer{
    @Override
    public String getName() {
        return "喜洋洋";
    }

    @Override
    public void update(String msg) {
        System.out.println("喜洋洋收到通知：" + msg);
    }
}
