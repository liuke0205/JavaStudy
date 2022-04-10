package 贪心;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author liuke
 * @date 2022/3/21 0:03
 */
public class Solution1353_最多可以参加的会议数目 {
    /**
     * https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended/
     *
     * 首先，对会议按照开始时间升序排列，排序的目的是为了可以方便的一起选择开始时间相同的会议
     * 然后从第 1 天开始，依次判断每一天是否可以参加会议，记当天为 currDay ，从第 1 天开始
     * 顺序遍历会议，将开始时间等于 currDay 的会议的结束时间放入小顶堆
     * 将堆顶结束时间小于 currDay 的会议从堆中删除，这些会议都是过时的，参加不到的会议
     * 如果堆不为空，则选择会议结束时间最小的会议参加，表示 currDay 这一天可以参加会议
     * currDay 往后走一天，判断下一天是否可以参加会议
     */
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        // 存储会议的结束时间（从小到大）
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int curDay = 1, idx = 0;
        int cnt = 0;
        while (idx < events.length || !heap.isEmpty()){
            // 把会议开始时间为curDay的所有会议的结束时间添加到heap中
            while (idx < events.length && curDay == events[idx][0]){
                heap.add(events[idx++][1]);
            }
            // 将堆中结束时间小于当前时间的会议remove
            while (!heap.isEmpty() && curDay > heap.peek()){
                heap.poll();
            }
            //pop掉当前天数之前的
            if (!heap.isEmpty()){
                cnt++;
                heap.poll();
            }
            curDay++;
        }
        return cnt;
    }
}
