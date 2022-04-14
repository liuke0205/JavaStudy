package Decorator;

/**
 * @author liuke
 * @date 2022/4/15 0:26
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Drink drink = new LongBlack();
        drink = new Milk(drink);
        drink = new Pudding(drink);
        System.out.println(drink.getDes());
        System.out.println(drink.cost());
    }
}
