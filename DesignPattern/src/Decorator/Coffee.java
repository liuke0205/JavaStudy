package Decorator;

/**
 * @author liuke
 * @date 2022/4/15 0:23
 */
public class Coffee extends Drink{
    @Override
    public float cost() {
        return super.getPrice();
    }
}
