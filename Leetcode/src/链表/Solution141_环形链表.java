package 链表;

/**
 * @author liuke
 * @date 2022/5/12 23:55
 */
public class Solution141_环形链表 {
    /**
     * 思路：
     * 1. 使用快慢指针，快慢指针起始位置一样，但是快指针每次走2步，慢指针每次走1步；
     * 2. 如果形成环状，那么快慢指针总会有相遇的时候【两个人在环形跑道跑步，速度不同，总会有相遇的时候】
     */
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                return true;
            }
        }
        return false;
    }
}
