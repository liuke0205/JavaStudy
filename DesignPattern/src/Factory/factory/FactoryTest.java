package Factory.factory;

/**
 * @author liuke
 * @date 2022/3/29 21:52
 */
public class FactoryTest {
    public static void main(String[] args) {
//        IFactory factory = new AddFactory();
        IFactory factory = new SubFactory();
        Operation operation = factory.getOperation();
        double result = operation.getResult(2, 3);
        System.out.println(result);
    }
}
