package MyLRU;
import java.util.HashMap;
import java.util.Map;


public class LRU {
    //双向链表的最大容量
    int capcity;
    Map<Integer, Node> cache;
    DoubleList list;

    public LRU(int capcity) {
        this.capcity = capcity;
        cache = new HashMap<>(this.capcity);
        list = new DoubleList();
    }

    public int get(int key) {
        int value = -1;
        if (cache.get(key) != null) {
            //1.确定返回的值
            value = cache.get(key).value;
            Node node = cache.get(key);
            //2.在链表中将Node删除
            list.delete(node);
            //3.在链表的首部添加Node
            list.addFirst(node);
        }
        return value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        //在map中存在key，更新map中的Node和链表中的位置和Node
        if (cache.containsKey(key)) {
            //1.更新map中的Node
            cache.put(key, node);
            //2.删除List中的Node
            list.delete(node);
            list.addFirst(node);
        } else {//如果不存在，那么map直接put，list添加到头部，判断容量
            cache.put(key, node);
            list.addFirst(node);
            if (cache.size() > this.capcity) {
                int last = list.deleteLast();
                cache.remove(last);
            }
        }
    }

    public void printList() {
        Node cur = list.head.next;
        while (cur.next.next != null) {
            System.out.print(cur.key + "->");
            cur = cur.next;
        }
        System.out.println(cur.key);
    }
}

class DoubleList {
    Node head, tail;

    public DoubleList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public void addFirst(Node node) {
        Node temp = head.next;
        head.next = node;
        node.next = temp;
        temp.pre = node;
        node.pre = head;
    }

    public int delete(Node node) {
        int key = node.key;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return key;
    }

    public int deleteLast() {
        if (head.next == tail) {
            return -1;
        }
        int key = tail.pre.key;
        delete(tail.pre);
        return key;
    }
}

class Node {
    int key, value;
    Node next;
    Node pre;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
