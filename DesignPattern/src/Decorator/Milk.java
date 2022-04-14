package Decorator;

/**
 * @author liuke
 * @date 2022/4/15 0:25
 */
public class Milk extends Decorator{
    public Milk(Drink drink) {
        super(drink);
        setDes("牛奶");
        setPrice(2.0f);
    }
}
