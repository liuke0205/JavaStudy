package Factory.abatract;

/**
 * @author liuke
 * @date 2022/3/29 22:52
 */
public class MySQLDepartment implements IDepartment{
    @Override
    public void insert() {
        System.out.println("MySQLDepartment insert");
    }

    @Override
    public void delete() {
        System.out.println("MySQLDepartment delete");
    }
}
