package Factory.abatract;

/**
 * @author liuke
 * @date 2022/3/29 22:48
 */
public class SqlServerUser implements IUser{
    @Override
    public void insert() {
        System.out.println("SqlServerUser Insert");
    }

    @Override
    public void delete() {
        System.out.println("SqlServerUser Delete");
    }
}
