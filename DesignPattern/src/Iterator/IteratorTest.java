package Iterator;

/**
 * @author liuke
 * @date 2022/4/9 16:22
 */
public class IteratorTest {
    public static void main(String[] args) {
        Aggregate<String> concreteAggregate = new ConcreteAggregate<String>();
        concreteAggregate.add("1");
        concreteAggregate.add("2");
        concreteAggregate.add("3");

        Iterator<String> iterator = concreteAggregate.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
