package 链表;

/**
 * @author liuke
 * @date 2022/3/21 21:51
 */
public class Solution25_翻转K个链表 {
    /**
     * 思路：
     * 1. 每k个为一组，找出左右边界进行翻转
     * 2. 如果剩余的不足k个，就不进行翻转
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null){
                return head;
            }
            cur = cur.next;
        }
        ListNode newHead = reverse(head, cur);
        head.next = reverseKGroup(cur, k);
        return newHead;
    }
    // 翻转[a, b)区间的链表
    public ListNode reverse(ListNode a, ListNode b){
        ListNode pre = null, head = a;
        while(head != b){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
