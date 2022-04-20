package Bridge;

/**
 * @author liuke
 * @date 2022/4/21 0:01
 */
public class HandsetBrandA extends HandsetBrand{
    public HandsetBrandA(HandsetSoft soft) {
        super(soft);
    }

    @Override
    public void run() {
        System.out.print("小米手机");
        getSoft().run();
    }
}
