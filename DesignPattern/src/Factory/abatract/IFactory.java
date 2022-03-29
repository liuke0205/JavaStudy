package Factory.abatract;

/**
 * @author liuke
 * @date 2022/3/29 22:42
 */
public interface IFactory {
    IUser createUser();
    IDepartment createDepartment();
}
