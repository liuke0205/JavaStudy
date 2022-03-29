package Factory.factory;

/**
 * @author liuke
 * @date 2022/3/29 21:49
 */
public class AddFactory implements IFactory{
    @Override
    public Operation getOperation() {
        return new AddOperation();
    }
}
