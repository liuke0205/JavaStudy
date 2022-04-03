package Prototype;

/**
 * @author liuke
 * @date 2022/2/26 11:35
 */
public class DeepClone implements Cloneable{
    String version;
    User user;
    public DeepClone(User user, String version){
        this.user = user;
        this.version = version;
    }

    @Override
    protected DeepClone clone() throws CloneNotSupportedException {
        DeepClone prototype = (DeepClone)super.clone();
        prototype.user = user.clone();
        return prototype;
    }
}
