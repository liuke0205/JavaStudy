package MyLRU;

public class LRUTest {
    public static void main(String[] args) {
        LRU lruCache = new LRU(5);
        for (int i = 0; i <= 6; i++) {
            lruCache.put(i, i);
        }
        lruCache.printList();
        lruCache.get(2);
        lruCache.printList();
        lruCache.get(3);
        lruCache.printList();
    }
}
