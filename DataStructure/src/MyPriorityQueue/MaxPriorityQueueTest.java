package MyPriorityQueue;

/**
 * @author liuke
 * @date 2022/3/17 22:57
 */
public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        MaxPriorityQueue<Integer> maxHeap = new MaxPriorityQueue<>();
        maxHeap.push(70);
        maxHeap.push(90);
        maxHeap.push(80);
        maxHeap.push(100);
        maxHeap.push(60);
        System.out.println("maxHeap test offer, heapInfo=" + maxHeap.toString());
        Integer maxValue = maxHeap.pop();
        System.out.println("maxHeap test getAndRemoveTop, maxValue=" + maxValue + ", heapInfo=" + maxHeap.toString());
    }
}
