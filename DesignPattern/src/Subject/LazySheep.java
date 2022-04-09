package Subject;

/**
 * @author liuke
 * @date 2022/4/9 17:27
 */
public class LazySheep implements Observer{
    @Override
    public String getName() {
        return "懒洋洋";
    }

    @Override
    public void update(String msg) {
        System.out.println("懒洋洋收到通知：" + msg);
    }
}
