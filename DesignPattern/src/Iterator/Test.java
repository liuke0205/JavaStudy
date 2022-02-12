package Iterator;

/**
 * @author liuke
 * @create 2021/03/18/15:11
 */
public class Test {
    public static void main(String[] args) {
        NameRespority nameRespority = new NameRespority();
        Iterator iterator = nameRespority.getIterator();
        while (iterator.hashNext()){
            System.out.println(iterator.next());
        }
    }
}
