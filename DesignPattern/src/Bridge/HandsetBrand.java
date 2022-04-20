package Bridge;

/**
 * @author liuke
 * @date 2022/4/20 23:59
 */
public abstract class HandsetBrand {
    private HandsetSoft soft;
    public HandsetBrand(HandsetSoft soft) {
        this.soft = soft;
    }
    public HandsetSoft getSoft() {
        return soft;
    }

    public abstract void run();
}
