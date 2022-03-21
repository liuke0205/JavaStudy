package 链表;

/**
 * @author liuke
 * @date 2022/3/21 21:51
 */
public class Solution25_翻转K个链表 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head;
        for(int i=0; i<k; i++){
            if(b == null){
                return head;
            }
            b = b.next;
        }
        ListNode new_head = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return new_head;
    }
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
