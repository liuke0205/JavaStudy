package Decorator;

/**
 * @author liuke
 * @date 2022/4/15 0:25
 */
public class Pudding extends Decorator{
    public Pudding(Drink drink) {
        super(drink);
        setDes("布丁");
        setPrice(2.5f);
    }
}
