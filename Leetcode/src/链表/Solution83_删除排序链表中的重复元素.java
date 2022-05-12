package 链表;

/**
 * @author liuke
 * @date 2022/5/13 0:41
 */
public class Solution83_删除排序链表中的重复元素 {
    /**
     * 思路：
     * 1. 双指针
     * 2. p1指针指向的是非重复的最后一个元素， p2指针作为遍历指针
     * 3. 当p1.val != p2.val 时，将p2的val赋给p1.next.val
     * 4. 最后需要将p1.next置为null
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null){
            if (p2.val != p1.val){
                p1.next.val = p2.val;
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        if (p1 != null){
            p1.next = null;
        }
        return head;
    }
}
