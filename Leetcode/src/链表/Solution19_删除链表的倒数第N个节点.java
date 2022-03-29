package 链表;

/**
 * @author liuke
 * @date 2022/3/29 20:30
 */
public class Solution19_删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode new_head = new ListNode(-1);
        new_head.next = head;
        ListNode cur = new_head, pre = new_head;
        while (n -- > 0){
            pre  = pre.next;
        }
        while (pre.next != null){
            cur = cur.next;
            pre = pre.next;
        }
        cur.next = cur.next.next;
        return new_head.next;
    }
}
