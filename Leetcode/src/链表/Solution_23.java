package 链表;

import java.util.PriorityQueue;

/**
 * @author liuke
 * @date 2022/3/6 10:45
 */
public class Solution_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->(a.val - b.val));
        for (ListNode node: lists) {
            if (node != null){
                pq.add(node);
            }
        }
        ListNode head = new ListNode(-1), cur = head;
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null){
                pq.add(node.next);
            }
        }
        return head.next;
    }
}
