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

class DiscountStrategyFactory{
    private static final Map<String, DiscountStrategy> map = new HashMap<>();
    static {
        map.put("1", new Discount95Strategy());
        map.put("2", new Discount90Strategy());
        map.put("3", new Discount85Strategy());
    }

    public static DiscountStrategy chooseStrategy(String type){
        return map.getOrDefault(type, new Discount100Strategy());
    }
}