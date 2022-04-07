package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuke
 * @date 2022/4/6 23:07
 */
public class Solution35_无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int end = intervals[0][1];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < end){
                cnt++;
            }else{
                end = intervals[i][1];
            }
        }
        return cnt;
    }
}
