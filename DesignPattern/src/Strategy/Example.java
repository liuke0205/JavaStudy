package Strategy;

import java.util.Objects;

/**
 * @author liuke
 * @date 2022/4/3 11:00
 */
public class Example {
    /**
     * 问题分析：
     *
     * 这段代码是能够满足项目中业务需求的，而且很多已上线生产环境的代码也有这类代码。但是，这一段代码存在存在两个弊端：
     * 1. 代码的复杂性，正常业务代码逻辑肯定会比这个代码块复杂很多，这也就导致了 if-else 的分支以及代码数量过多。
     *      这种方式可以通过将代码拆分成独立函数或者拆分成类来解决
     * 2. 不符合开闭原则，价格优惠肯定会 随着不同的时期作出不同的改变，或许新增、删除或修改。
     *      如果在一个函数中修改无疑是件恐怖的事情，想想可能多个开发者分别进行开发，杂乱无章的注释，混乱的代码逻辑等情况十有八九会发生。
     */
    public static void main(String[] args) {
        Double discount = discount("1", 200.0);
        System.out.println(discount);
    }


    public static Double discount(String type, Double price){
        if (Objects.equals(type,"1")){           // 优惠9.5折
            return price * 0.95;
        }else if (Objects.equals(type,"2")){     // 优惠9折
            return price *0.9;
        }else if (Objects.equals(type,"3")){     // 优惠8.5折
            return price *0.85;
        } else {                                    // 无优惠
            return price;
        }
    }
}
