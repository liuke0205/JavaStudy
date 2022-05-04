package Strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuke
 * @date 2022/4/3 11:06
 */

interface DiscountStrategy {
    Double discount(Double price);
}
class Discount95Strategy implements DiscountStrategy{
    @Override
    public Double discount(Double price) {
        return price * 0.95;
    }
}
class Discount90Strategy implements DiscountStrategy{
    @Override
    public Double discount(Double price) {
        return price * 0.90;
    }
}
class Discount85Strategy implements DiscountStrategy{
    @Override
    public Double discount(Double price) {
        return price * 0.85;
    }
}
class Discount100Strategy implements DiscountStrategy{
    @Override
    public Double discount(Double price) {
        return price;
    }
}
class Context{
    private DiscountStrategy strategy;
    public Context(DiscountStrategy strategy){
        this.strategy = strategy;
    }

    public double exec(double price){
        return strategy.discount(price);
    }
}