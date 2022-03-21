package 双指针;

/**
 * @author liuke
 * @date 2022/3/21 10:42
 */
public class Solution142_环形链表II {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head, fast = head;
        boolean flag = false;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                flag = true;
                break;
            }
        }
        if (!flag){
            return null;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
