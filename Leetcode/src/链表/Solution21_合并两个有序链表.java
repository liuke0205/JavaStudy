package 链表;

/**
 * @author liuke
 * @date 2022/5/12 0:23
 */
public class Solution21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(-1), head = temp;
        ListNode p = list1, q = list2;
        while (p != null && q != null){
            if (p.val > q.val){
                head.next = q;
                q = q.next;
            }else {
                head.next = p;
                p = p.next;
            }
            head = head.next;
        }
        head.next = (p != null) ? p: q;
        return temp.next;
    }
}
