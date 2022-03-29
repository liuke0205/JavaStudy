package Factory.abatract;

/**
 * @author liuke
 * @date 2022/3/29 22:48
 */
public class SqlServerFactory implements IFactory{
    @Override
    public IUser createUser() {
        return new MySQLUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new MySQLDepartment();
    }
}
