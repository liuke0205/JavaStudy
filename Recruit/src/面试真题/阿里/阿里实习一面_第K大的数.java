package 面试真题.阿里;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author liuke
 * @date 2022/3/15 10:28
 */
public class 阿里实习一面_第K大的数 {
    public static void main(String[] args) {

    }

    public int topK(Iterator<Integer> iterator, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        while (iterator.hasNext()){
            int num = iterator.next();
            heap.add(num);
            if (heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}
