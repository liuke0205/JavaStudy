package Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/9 16:02
 */
public class ConcreteIterator<T> implements Iterator<T> {
    private List<T> mList = new ArrayList<>();
    private int cursor = 0;

    public ConcreteIterator(List<T> list){
        this.mList = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != mList.size();
    }

    @Override
    public T next() {
        if (this.hasNext()){
            return this.mList.get(cursor++);
        }
        return null;
    }
}
