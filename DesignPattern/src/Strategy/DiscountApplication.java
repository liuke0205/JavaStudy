package Strategy;

/**
 * @author liuke
 * @date 2022/4/3 11:13
 */
public class DiscountApplication {
    public static void main(String[] args) {
        DiscountStrategy discountStrategy = DiscountStrategyFactory.chooseStrategy("1");
        Double discount = discountStrategy.discount(200D);
        System.out.println(discount);
    }
}
