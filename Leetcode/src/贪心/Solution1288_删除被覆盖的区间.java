package 贪心;

import java.util.Arrays;

/**
 * @author liuke
 * @date 2022/4/7 0:14
 */
public class Solution1288_删除被覆盖的区间 {
    /**
     * https://leetcode-cn.com/problems/remove-covered-intervals/
     *
     * 贪心策略：按照起点升序，起点相同时按照终点降序。在当前区间找其他区间包含在当前区间
     */
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (o1, o2)->{
            if (o1[0] == o2[0]){
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int start = intervals[0][0], end = intervals[0][1];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            //一个区间被另一个区间完全覆盖
            if(intervals[i][1] <= end && intervals[i][0] >= start){
                cnt++;
            }
            //两个区间交叉
            if(end >= intervals[i][0] && end <= intervals[i][1]){
                end = intervals[i][1];
            }
            //两个区间完全没有交集
            if(end < intervals[i][0]){
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}
