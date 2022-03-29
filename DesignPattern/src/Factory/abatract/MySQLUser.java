package Factory.abatract;

/**
 * @author liuke
 * @date 2022/3/29 22:48
 */
public class MySQLUser implements IUser{
    @Override
    public void insert() {
        System.out.println("MySQLUser Insert");
    }

    @Override
    public void delete() {
        System.out.println("MySQLUser Delete");
    }
}
