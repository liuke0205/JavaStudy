package Factory.factory;

/**
 * @author liuke
 * @date 2022/3/29 21:52
 */
public class SubOperation implements Operation{
    @Override
    public double getResult(double a, double b) {
        return a - b;
    }
}
