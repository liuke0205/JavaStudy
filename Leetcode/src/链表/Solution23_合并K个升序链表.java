package 链表;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author liuke
 * @date 2022/3/6 10:45
 */
public class Solution23_合并K个升序链表 {
    /**
     * 思路：
     * 1. 正常思路是维护k个指针，然后每次取k个指针的最小值，然后最小值的节点往后移
     * 2. 但是每次取取k个节点的最小值时间复杂度比较高，可以考虑使用 优先队列 去维护数据
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) ->{
            return a.val - b.val;
        });

        for (ListNode node: lists) {
            if (node != null){
                heap.add(node);
            }
        }
        ListNode head = new ListNode(-1), p = head;
        while (!heap.isEmpty()){
            ListNode node = heap.poll();
            p.next = node;
            p = p.next;
            if (node.next != null){
                heap.add(node.next);
            }
        }
        return head.next;
    }
}
