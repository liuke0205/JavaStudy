package 贪心;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/4/7 0:20
 */
public class Solution435_无重叠区间 {
    /**
     * https://leetcode-cn.com/problems/non-overlapping-intervals/
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照右边界从小到大排序，使得右边界越小，留给其他元素的区间越大
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int len = intervals.length;
        int end = intervals[0][1];
        int cnt = 1;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= end){
                cnt++;
                end = intervals[i][1];
            }
        }
        return len - cnt;
    }
}
