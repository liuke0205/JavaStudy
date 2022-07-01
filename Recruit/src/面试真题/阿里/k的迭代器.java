package 面试真题.阿里;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author liuke
 * @date 2022/3/16 18:03
 */

//面试题目：利用多个有序的Iterator，实现全局有序Iterator
/**
 * 输入一个iterators数组，这个数组中的每个iterator返回的元素都是有序的（升序）。
 * 这个类要实现一个iterator，它把iterators数组代表的iterator看作一个整体，返回整体有序的结果。
 * 举个例子：
 *      iterators数组包含两个iterator。
 *      iterator 1返回：1 3 4 6 7 8
 *      iterator 2返回：2 5 9 10
 *      那么这个类返回的元素序列为： 1 2 3 4 5 6 7 8 9 10
 * 实现限制：
 * 1. 你能使用的内存必须和元素的个数无关。即即使元素的个数是无穷多个，你的程序也应该只需要很小的内存就可以运行。
 * 2. 不能对这个类的使用者作假定。比方说不能假定moveNext()和getCurrentElement()一定是成对调用的。
 * */
public class k的迭代器 {
    public static void main(String[] args) {

    }
}
class TotalOrderIterator<T extends Comparable<T>> implements Iterator<T> {
    private Iterator<T>[] iterators;
    private int valiad;
    PriorityQueue<Iterator<T>> heap = new PriorityQueue<>(
        (a, b) -> {
            return a.getCurrentElement().compareTo(b.getCurrentElement());
        }
    );

    public TotalOrderIterator(Iterator<T>[] iterators) {
        this.iterators = iterators;
        for(Iterator<T> iter : iterators){
            heap.add(iter);
            valiad++;
        }
    }

    @Override
    public T getCurrentElement() {
        Iterator<T> curIterator = heap.peek();
        assert curIterator != null;
        return curIterator.getCurrentElement();
    }

    @Override
    public boolean moveNext() {
        Iterator<T> curIterator = heap.peek();
        assert curIterator != null;
        if(!curIterator.moveNext()){
            valiad--;
        }
        return valiad > 0;
    }
}

/**
 * Iterator 表示了一个元素序列。 这个元素序列在什么位置，以及如何存储都是未知的。*
 * 这个元素序列可能非常非常长，有几十亿个元素，或者可能是无穷无尽的。
 * */
interface Iterator<T extends Comparable<T>> {

    /** 返回当前游标位置的元素*
     *  @return 当前游标位置的元素*
     * */
    T getCurrentElement();

    /** 游标移动到下一个元素。*
     *  注意：Iterator在初始时游标位于第一个元素之前！！！！*
     *  @return 移动到合法游标位置，返回true, 否则返回false*
     **/
     boolean moveNext();
}