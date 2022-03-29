package 链表;

/**
 * @author liuke
 * @date 2022/3/29 17:29
 */
public class Solution707_设计链表 {

}

class Node{
    int val;
    Node next;
    Node prev ;
    public Node(int val){
        this.val = val;
    }
}
class MyLinkedList {
    Node head, tail;
    int size;
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev  = head;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        int idx = 0;
        Node cur = head;
        while (idx++ <= index){
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index >= 0 && index <= size){
            Node node = new Node(val);
            Node cur = head;
            while (index-- > 0){
                cur = cur.next;
            }
            Node next = cur.next;
            node.next = next;
            next.prev  = node;
            cur.next = node;
            node.prev  = cur;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size){
            int idx = 0;
            Node cur = head;
            while (idx++ <= index){
                cur = cur.next;
            }
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
        }
    }
}
