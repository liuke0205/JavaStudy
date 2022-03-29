package Factory.abatract;

/**
 * @author liuke
 * @date 2022/3/29 23:00
 */
public class AbatractFactoryTest {
    public static void main(String[] args) {
        IFactory factory = new MySQLFactory();
        IUser user = factory.createUser();
        user.delete();
        user.insert();

        IDepartment department = factory.createDepartment();
        department.delete();
        department.insert();
    }
}