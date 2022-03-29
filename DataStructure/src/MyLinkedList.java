/**
 * @author liuke
 * @date 2022/3/29 17:35
 */

class ListNode{
    int val;
    ListNode next;
    ListNode prev ;
    public ListNode(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    ListNode head, tail;
    int size;
    public MyLinkedList() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev  = head;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        int idx = 0;
        ListNode cur = head;
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
            ListNode node = new ListNode(val);
            ListNode cur = head;
            while (index-- > 0){
                cur = cur.next;
            }
            ListNode next = cur.next;
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
            ListNode cur = head;
            while (idx++ <= index){
                cur = cur.next;
            }
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
        }
    }
}
