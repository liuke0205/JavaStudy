package 链表;

/**
 * @author liuke
 * @date 2022/5/13 0:52
 */
public class Solution92_翻转链表II {
    /**
     * 思路：
     * 1. 找出需要翻转的头和尾
     * 2. 对区域链表翻转
     * 3. 将之前的链表 和 翻转后的链表进行拼接
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dym = new ListNode(-1);
        dym.next = head;
        //1.找到head的第left个节点为cur，保存left-1个节点的值为p
        ListNode p = dym;
        for(int i=1; i<left; i++){
            p = p.next;
        }
        ListNode cur = p.next;
        ListNode pre = null;
        //2. 180°旋转爆炸
        for(int i=0; i<=right - left; i++){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        //3. 修改m和n-m位置处的节点的指向
        p.next.next = cur;
        p.next = pre;
        return dym.next;
    }
}
