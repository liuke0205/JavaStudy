package Bridge;

/**
 * @author liuke
 * @date 2022/4/21 0:01
 */
public class HandsetBrandB extends HandsetBrand{
    public HandsetBrandB(HandsetSoft soft) {
        super(soft);
    }

    @Override
    public void run() {
        System.out.print("华为手机");
        getSoft().run();
    }
}
