public class MyPriorityQueue<Key extends Comparable<Key>> {
    //存储元素的数组
    private Key[] pq;
    //元素的数量
    private int cnt = 0;

    public MyPriorityQueue(int cap) {
        pq = (Key[]) new Comparable[cap + 1];
    }

    /**
     * 返回当前队列的最大值
     */
    public Key max() {
        return pq[1];
    }

    /**
     * 插入元素e
     */
    public void insert(Key e) {
        cnt++;
        pq[cnt] = e;
        swim(cnt);
    }

    /**
     * 删除并返回队列的最大值
     */
    public Key delMax() {
        Key max = pq[1];
        exch(1, cnt);
        pq[cnt] = null;
        cnt--;
        sink(1);
        return max;
    }

    /**
     * 上浮第k个元素
     */
    private void swim(int k) {
        while (k > 1 && less(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 下沉第k个元素
     */
    private void sink(int k) {
        while (left(k) <= cnt) {
            int max = left(k);
            if (right(k) <= cnt && less(left(k), right(k))) {
                max = right(k);
            }
            if (less(max, k)) {
                break;
            } else {
                exch(max, k);
                k = max;
            }
        }
    }

    /**
     * 获取当前元素的父节点下标
     */
    private int parent(int cur) {
        return cur / 2;
    }

    /**
     * 获取当前元素的左孩子节点
     */
    private int left(int cur) {
        return cur * 2;
    }

    /**
     * 获取当前元素的右孩子节点
     */
    private int right(int cur) {
        return cur * 2 + 1;
    }


    /* 交换数组的两个元素 */
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* pq[i] 是否比 pq[j] 小？ */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue<Integer> integerMaxPQ = new MyPriorityQueue<>(3);
        integerMaxPQ.insert(2);
        integerMaxPQ.insert(4);
        System.out.println(integerMaxPQ.max());
        System.out.println(integerMaxPQ.delMax());
        System.out.println(integerMaxPQ.max());
    }
}