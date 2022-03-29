package 链表;

/**
 * @author liuke
 * @date 2022/3/29 20:24
 */
public class Solution206_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
