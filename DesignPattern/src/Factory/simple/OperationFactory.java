package Factory.simple;

import Factory.factory.AddOperation;
import Factory.factory.Operation;
import Factory.factory.SubOperation;

/**
 * @author liuke
 * @date 2022/3/29 21:57
 */
public class OperationFactory {
    public static Operation getOperate(String operate){
        Operation operation = null;
        switch (operate){
            case "+":
                operation = new AddOperation();
                break;
            case "-":
                operation = new SubOperation();
                break;
        }
        return operation;
    }
}
