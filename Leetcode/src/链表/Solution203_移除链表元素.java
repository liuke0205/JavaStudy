package 链表;

/**
 * @author liuke
 * @date 2022/3/29 16:50
 */
public class Solution203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head, new_head = new ListNode(-1);
        new_head.next = head;
        ListNode pre = new_head;
        while (cur != null){
            if (cur.val == val){
                ListNode temp = cur.next;
                pre.next = temp;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return new_head.next;
    }
}
