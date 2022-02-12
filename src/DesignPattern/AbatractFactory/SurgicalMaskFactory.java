package AbatractFactory;

/**
 * @author liuke
 * @create 2021/03/31/19:21
 */
public class SurgicalMaskFactory extends IFactory{
    public Mask create(){
        return new SurgicalMask();
    }
}
