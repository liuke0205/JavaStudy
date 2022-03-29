package Factory.simple;

import Factory.factory.Operation;

/**
 * @author liuke
 * @date 2022/3/29 21:52
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        Operation operation = OperationFactory.getOperate("+");
        double result = operation.getResult(2, 3);
        System.out.println(result);
    }
}
