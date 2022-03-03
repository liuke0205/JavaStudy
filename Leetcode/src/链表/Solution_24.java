package 链表;

import java.util.List;

/**
 * @author liuke
 * @date 2022/3/3 22:07
 */
public class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode new_head = head.next.next;
        ListNode next = head.next;
        next.next = head;
        head.next = swapPairs(new_head);
        return next;
    }
}
