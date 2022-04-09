package Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/9 16:19
 */
public class ConcreteAggregate<T> implements Aggregate<T> {
    private final List<T> mLists = new ArrayList<>();

    @Override
    public void add(T t) {
        mLists.add(t);
    }

    @Override
    public void remove(T t) {
        mLists.remove(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ConcreteIterator<T>(mLists);
    }
}
