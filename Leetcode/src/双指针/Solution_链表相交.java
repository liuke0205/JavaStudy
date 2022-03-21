package 双指针;

/**
 * @author liuke
 * @date 2022/3/21 10:27
 */
public class Solution_链表相交 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b){
            if (a == null){
                a = headB;
            }else {
                a = a.next;
            }
            if (b == null){
                b = headA;
            }else {
                b = b.next;
            }
        }
        return a;
    }
}
