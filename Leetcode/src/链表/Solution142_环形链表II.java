package 链表;


/**
 * @author liuke
 * @date 2022/3/21 10:42
 */
public class Solution142_环形链表II {
    /**
     * 思路：
     * 1. 首先使用环形链表的思想确定是否存在环
     * 2. 如果存在环，那么将快慢指针随便一个指向 head，然后快慢指针分别
     */
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
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
