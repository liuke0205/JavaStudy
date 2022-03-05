package Factory;

/**
 * @author liuke
 * @create 2021/03/31/18:58
 */
public class MaskFactory {
    public Mask create(String type){
        Mask mask =  null;
        switch (type){
            case "N95" : mask = new N95Mask();break;
            case "Surgical": mask = new SurgicalMask();break;
        }
        return mask;
    }
}