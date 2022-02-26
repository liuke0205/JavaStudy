package Prototype;

/**
 * @author liuke
 * @date 2022/2/26 11:35
 */
public class ShallowClone implements Cloneable{
    String version;
    User user;
    public ShallowClone(String version, User user){
        this.user = user;
        this.version = version;
    }

    @Override
    protected ShallowClone clone() throws CloneNotSupportedException {
        return (ShallowClone) super.clone();
    }
}
