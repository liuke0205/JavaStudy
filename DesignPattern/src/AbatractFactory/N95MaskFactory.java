package AbatractFactory;

/**
 * @author liuke
 * @create 2021/03/31/19:21
 */
public class N95MaskFactory extends IFactory{
    public Mask create(){
        return new N95Mask();
    }
}
