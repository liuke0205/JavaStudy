package Iterator;

/**
 * @author liuke
 * @date 2022/4/9 16:18
 */
public interface Aggregate<T> {
    void add(T t);
    void remove(T t);
    Iterator<T> iterator();
}
